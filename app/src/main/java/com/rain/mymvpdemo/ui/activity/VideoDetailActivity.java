package com.rain.mymvpdemo.ui.activity;

import android.annotation.TargetApi;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.Constants;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseActivity;
import com.rain.mymvpdemo.base.MyVideoCallBack;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.contract.VideoDetailContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.VideoDetailPresenter;
import com.rain.mymvpdemo.ui.adapter.VideoDetailAdapter;
import com.rain.mymvpdemo.util.ToastUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:rain
 * Date:2018/6/12 9:31
 * Description:
 */
public class VideoDetailActivity extends BaseActivity implements VideoDetailContract.View, OnRefreshListener {
    public static final String IMG_TRANSITION = "IMG_TRANSITION";
    public static final String TRANSITION = "TRANSITION";
    @BindView(R.id.mVideoView)
    StandardGSYVideoPlayer mVideoView;
    @BindView(R.id.mVideoBackground)
    ImageView mVideoBackground;
    @BindView(R.id.mRecyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.mRefreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private VideoDetailPresenter presenter;
    private HomeBean.IssueListBean.ItemListBean itemListBean;
    private boolean isPlay;
    private boolean isPause;
    private static final String TAG = "VideoDetailActivity";
    private VideoDetailAdapter adapter;
    private View videoInfoHeader;
    private OrientationUtils orientationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getCurPlay().onVideoResume();
        isPause = false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        getCurPlay().onVideoPause();
        isPause = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void loadData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        presenter = new VideoDetailPresenter();
        presenter.attachView(this);
        getIntentData();
        initRecycler();
        // 过渡动画,动画完成后加载数据
        initTransition();
        initVideoViewConfig();
    }

    private void initVideoViewConfig() {
        //设置旋转
        orientationUtils = new OrientationUtils(this, mVideoView);
        //是否旋转
        mVideoView.setRotateViewAuto(false);
        //是否可以滑动调整
        mVideoView.setIsTouchWiget(true);
        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        GlideApp.with(this)
                .load(itemListBean.getData().getCover().getFeed())
                .centerCrop()
                .into(imageView);
        mVideoView.setThumbImageView(imageView);
        mVideoView.setVideoAllCallBack(new MyVideoCallBack() {
            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                // 开始播放了才能旋转和全屏
                orientationUtils.setEnable(true);
                isPlay = true;
            }

            @Override
            public void onPlayError(String url, Object... objects) {
                super.onPlayError(url, objects);
                ToastUtil.showToast("播放失败");
            }

            @Override
            public void onQuitFullscreen(String url, Object... objects) {
                super.onQuitFullscreen(url, objects);
                // 列表返回的样式判断
                orientationUtils.backToProtVideo();
            }
        });
        // 设置返回按键功能
        mVideoView.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // 设置全屏按键功能
        mVideoView.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
                // 第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                mVideoView.startWindowFullscreen(VideoDetailActivity.this, true, true);
            }
        });
        // 锁屏事件
        mVideoView.setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                orientationUtils.setEnable(!lock);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (isPlay & !isPause) {
            mVideoView.onConfigurationChanged(this, newConfig, orientationUtils);
        }
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new VideoDetailAdapter(null);
        videoInfoHeader = LayoutInflater.from(this).inflate(R.layout.item_video_detail_info, null);
        adapter.addHeaderView(videoInfoHeader);
        recyclerView.setAdapter(adapter);
        mRefreshLayout.setOnRefreshListener(this);
        // 内容随swipe偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        MaterialHeader refreshHeader = (MaterialHeader) mRefreshLayout.getRefreshHeader();
        // 显示下拉背景
        refreshHeader.setShowBezierWave(true);
        mRefreshLayout.setPrimaryColorsId(R.color.lineColor, R.color.color_title_bg);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HomeBean.IssueListBean.ItemListBean data = (HomeBean.IssueListBean.ItemListBean) adapter.getData().get(position);
                int itemType = data.getItemType();
                if (HomeBean.IssueListBean.ItemListBean.type_video_small_card == itemType) {
                    presenter.loadVideoInfo(data);
                }
            }
        });
    }

    private void initTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            postponeEnterTransition();
            ViewCompat.setTransitionName(mVideoView, IMG_TRANSITION);
            addTransitionListener();
            startPostponedEnterTransition();
        } else {
            loadVideoInfo();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void addTransitionListener() {
        Transition transition = getWindow().getSharedElementEnterTransition();
        if (transition != null) {
            transition.addListener(new Transition.TransitionListener() {

                @Override
                public void onTransitionStart(Transition transition) {
                }

                @Override
                public void onTransitionEnd(Transition transition) {
                    loadVideoInfo();
                    transition.removeListener(this);
                }

                @Override
                public void onTransitionCancel(Transition transition) {
                }

                @Override
                public void onTransitionPause(Transition transition) {
                }

                @Override
                public void onTransitionResume(Transition transition) {
                }
            });
        }

    }

    @Override
    public void setBackground(String url) {
        GlideApp.with(this)
                .load(url)
                .centerCrop()
                .format(DecodeFormat.PREFER_ARGB_8888)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(mVideoBackground);
    }

    // 加载视频信息
    private void loadVideoInfo() {
        presenter.loadVideoInfo(itemListBean);
    }

    @Override
    public void setVideo(String url) {
        mVideoView.setUp(url, false, "");
        mVideoView.startPlayLogic();
    }

    @Override
    public void setVideoInfo(HomeBean.IssueListBean.ItemListBean videoInfo) {
        adapter.setVideoDetailInfo(videoInfoHeader, videoInfo);
        presenter.requestRelatedVideo((long) videoInfo.getData().getId());
    }

    private void getIntentData() {
        if (getIntent().hasExtra(Constants.BUNDLE_VIDEO_DATA)) {
            itemListBean = ((HomeBean.IssueListBean.ItemListBean) getIntent().getSerializableExtra(Constants.BUNDLE_VIDEO_DATA));
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        loadVideoInfo();
    }

    @Override
    public void setRelatedVideo(List<HomeBean.IssueListBean.ItemListBean> videos) {
        adapter.setNewData(videos);
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {
        mRefreshLayout.finishRefresh();
    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {
        ToastUtil.showToast("msg:" + err_msg);
    }

    @Override
    public void onBackPressed() {
        if (mVideoView.isIfCurrentIsFullscreen()) {
            orientationUtils.backToProtVideo();
            return;
        }
        mVideoView.release();
        orientationUtils.releaseListener();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            super.onBackPressed();
        } else {
            finish();
            overridePendingTransition(R.anim.anim_out, R.anim.anim_in);
        }
    }

    private GSYVideoPlayer getCurPlay() {
        if (mVideoView.getFullWindowPlayer() != null) {
            return mVideoView.getFullWindowPlayer();
        } else return mVideoView;
    }

}
