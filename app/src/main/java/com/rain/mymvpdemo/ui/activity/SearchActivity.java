package com.rain.mymvpdemo.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.classic.common.MultipleStatusView;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseActivity;
import com.rain.mymvpdemo.mvp.contract.SearchContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.SearchPresenter;
import com.rain.mymvpdemo.util.ViewAnimUtils;

import java.util.ArrayList;

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

    @Override
    protected void loadData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        // presenter绑定view
        presenter = new SearchPresenter();
        presenter.attachView(this);
        // 设置进场出场动画
        setAnim();

    }

    private void setAnim() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setUpEnterAnimation();

        } else {

        }
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
        //打开软键盘
//        openKeyBord(et_search_view, applicationContext)
    }


    @Override
    public void setHotWordData(ArrayList<String> string) {

    }

    @Override
    public void setSearchResult(HomeBean.IssueListBean issue) {

    }

    @Override
    public void closeSoftKeyboard() {

    }

    @Override
    public void setEmptyView() {

    }

    @Override
    public void showError(String errorMsg, int errorCode) {

    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {

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
}
