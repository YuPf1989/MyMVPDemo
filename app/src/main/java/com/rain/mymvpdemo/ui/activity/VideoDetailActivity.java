package com.rain.mymvpdemo.ui.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.rain.mymvpdemo.Constants;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseActivity;
import com.rain.mymvpdemo.mvp.contract.VideoDetailContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.VideoDetailPresenter;
import com.rain.mymvpdemo.ui.adapter.VideoDetailAdapter;
import com.rain.mymvpdemo.util.ToastUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

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
    private static final String TAG  = "VideoDetailActivity";
    private VideoDetailAdapter adapter;

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

    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new VideoDetailAdapter(null);
//        adapter.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_video_detail_info, null));
        recyclerView.setAdapter(adapter);
        mRefreshLayout.setOnRefreshListener(this);
        // 内容随swipe偏移
        mRefreshLayout.setEnableHeaderTranslationContent(true);
        MaterialHeader refreshHeader = (MaterialHeader) mRefreshLayout.getRefreshHeader();
        // 显示下拉背景
        refreshHeader.setShowBezierWave(true);
        mRefreshLayout.setPrimaryColorsId(R.color.lineColor, R.color.color_title_bg);
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
        adapter.addData(videoInfo);
        presenter.requestRelatedVideo((long) videoInfo.getId());
    }

    private void getIntentData() {
        if (getIntent().hasExtra(Constants.BUNDLE_VIDEO_DATA)) {
            itemListBean = ((HomeBean.IssueListBean.ItemListBean) getIntent().getSerializableExtra(Constants.BUNDLE_VIDEO_DATA));
        }
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {

    }

    @Override
    public void setRelatedVideo(List<HomeBean.IssueListBean.ItemListBean> videos) {
        adapter.addData((HomeBean.IssueListBean.ItemListBean) videos);
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
        ToastUtil.showToast("msg:"+err_msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.mVideoBackground)
    public void onViewClicked() {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }


}
