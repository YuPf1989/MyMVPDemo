package com.rain.mymvpdemo.ui.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseActivity;
import com.rain.mymvpdemo.mvp.contract.SearchContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.SearchPresenter;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.ui.adapter.HotWordAdapter;
import com.rain.mymvpdemo.ui.adapter.RankAdapter;
import com.rain.mymvpdemo.util.SoftKeyboardUtil;
import com.rain.mymvpdemo.util.ToastUtil;
import com.rain.mymvpdemo.util.ViewAnimUtils;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author:rain
 * Date:2018/6/13 16:00
 * Description:
 */
public class SearchActivity extends BaseActivity implements SearchContract.View {

    @BindView(R.id.fab_circle)
    FloatingActionButton fabCircle;
    @BindView(R.id.et_search_view)
    EditText etSearchView;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.rel_search_view)
    RelativeLayout relSearchView;
    @BindView(R.id.tv_title_tip)
    TextView tvTitleTip;
    @BindView(R.id.tv_hot_search_words)
    TextView tvHotSearchWords;
    @BindView(R.id.mRecyclerView_hot)
    RecyclerView mRecyclerViewHot;
    @BindView(R.id.layout_hot_words)
    LinearLayout layoutHotWords;
    @BindView(R.id.tv_search_count)
    TextView tvSearchCount;
    @BindView(R.id.mRecyclerView_result)
    RecyclerView mRecyclerViewResult;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    @BindView(R.id.layout_content_result)
    LinearLayout layoutContentResult;
    @BindView(R.id.rel_container)
    LinearLayout relContainer;
    @BindView(R.id.rel_frame)
    RelativeLayout relFrame;
    private SearchPresenter presenter;

    private static final String TAG = "SearchActivity";
    private String keyword;
    private RankAdapter searchResultAdapter;

    // multipleStatusView点击加载
    @Override
    protected void loadData() {
        presenter.requestHotWordData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mLayoutStatusView = multipleStatusView;
        // presenter绑定view
        presenter = new SearchPresenter();
        presenter.attachView(this);
        // 设置进场出场动画
        setAnim();
        initSearchResultRecycler();
        // 加载热门搜索关键词
        presenter.requestHotWordData();
        // 取消
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        // 键盘的搜索按钮
        etSearchView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    SoftKeyboardUtil.hideSoftKeyboard(SearchActivity.this);
                    keyword = etSearchView.getText().toString().trim();
                    if (TextUtils.isEmpty(keyword)) {
                        ToastUtil.showToast("请输入你感兴趣的关键词");
                    } else {
                        presenter.querySearchData(keyword);
                    }
                }
                return false;
            }
        });
    }

    private void initSearchResultRecycler() {
        mRecyclerViewResult.setLayoutManager(new LinearLayoutManager(this));
        searchResultAdapter = new RankAdapter(R.layout.item_category_detail, null);
        mRecyclerViewResult.setAdapter(searchResultAdapter);
        searchResultAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.loadMoreData();
            }
        }, mRecyclerViewResult);
    }

    private void setAnim() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setUpEnterAnimation();
            setUpExitAnimation();
        } else {
            setUpView();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setUpExitAnimation() {
        Fade fade = new Fade();
        getWindow().setReturnTransition(fade);
        fade.setDuration(300);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setUpEnterAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.arc_motion);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {

            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow();
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void animateRevealShow() {
        ViewAnimUtils.animateRevealShow(
                this, relFrame,
                fabCircle.getWidth() / 2, R.color.background,
                new ViewAnimUtils.OnRevealAnimationListener() {

                    @Override
                    public void onRevealHide() {

                    }

                    @Override
                    public void onRevealShow() {
                        setUpView();
                    }
                });
    }

    private void setUpView() {
        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        animation.setDuration(300);
        relContainer.startAnimation(animation);
        relContainer.setVisibility(View.VISIBLE);
        // 打开软键盘
        SoftKeyboardUtil.showSoftInputFromWindow(this, etSearchView);
    }

    @Override
    public void setHotWordData(ArrayList<String> string) {
        showHotWordView();
        FlexboxLayoutManager flexManager = new FlexboxLayoutManager(this);
        flexManager.setFlexWrap(FlexWrap.WRAP); // 按正常方向换行
        flexManager.setFlexDirection(FlexDirection.ROW); // 主轴为水平方向，起点在左端
        flexManager.setAlignItems(AlignItems.CENTER); // 定义项目在副轴轴上如何对齐
        flexManager.setJustifyContent(JustifyContent.FLEX_START); // 多个轴对齐方式
        mRecyclerViewHot.setLayoutManager(flexManager);
        HotWordAdapter hotWordAdapter = new HotWordAdapter(R.layout.item_flow_text, string);
        mRecyclerViewHot.setAdapter(hotWordAdapter);
        hotWordAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SoftKeyboardUtil.hideSoftKeyboard(SearchActivity.this);
                keyword = (String) adapter.getData().get(position);
                presenter.querySearchData(keyword);
            }
        });
    }

    private void hideHotWordView() {
        layoutHotWords.setVisibility(View.GONE);
        layoutContentResult.setVisibility(View.VISIBLE);
    }

    private void showHotWordView() {
        layoutHotWords.setVisibility(View.VISIBLE);
        layoutContentResult.setVisibility(View.GONE);
    }

    @Override
    public void setSearchResult(HomeBean.IssueListBean issue) {
        hideHotWordView();
        tvSearchCount.setVisibility(View.VISIBLE);
        tvSearchCount.setText(String.format(getResources().getString(R.string.search_result_count), keyword, issue.getTotal()));
        List<HomeBean.IssueListBean.ItemListBean> itemList = issue.getItemList();
        searchResultAdapter.setNewData(itemList);
    }

    @Override
    public void setLoadMoreData(Object o) {
        HomeBean.IssueListBean issueListBean = (HomeBean.IssueListBean) o;
        List<HomeBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
        searchResultAdapter.addData(itemList);
    }

    @Override
    public void setEmptyView() {
        ToastUtil.showToast("抱歉，没有找到相匹配的内容");
        hideHotWordView();
        tvSearchCount.setVisibility(View.GONE);
        mLayoutStatusView.showEmpty();
    }

    @Override
    public void onLoadComplete() {
        searchResultAdapter.loadMoreComplete();
    }

    @Override
    public void onLoadEnd() {
        searchResultAdapter.loadMoreEnd();
    }

    @Override
    public void onLoadFail() {
        searchResultAdapter.loadMoreFail();
    }

    @Override
    public void onShowLoading() {
        multipleStatusView.showLoading();
    }

    @Override
    public void onHideLoading() {
        multipleStatusView.showContent();
    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {
        ToastUtil.showToast(err_msg);
        if (err_code == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView.showNoNetwork();
        } else {
            mLayoutStatusView.showError();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ViewAnimUtils.animateRevealHide(
                    this, relFrame,
                    fabCircle.getWidth() / 2, R.color.background,
                    new ViewAnimUtils.OnRevealAnimationListener() {

                        @Override
                        public void onRevealHide() {
                            defaultOnBackPressed();
                        }

                        @Override
                        public void onRevealShow() {
                        }
                    });
        } else {
            defaultOnBackPressed();
        }
    }

    // 关闭软键盘同时关闭当前界面
    private void defaultOnBackPressed() {
        SoftKeyboardUtil.hideSoftKeyboard(this);
        super.onBackPressed();
    }
}
