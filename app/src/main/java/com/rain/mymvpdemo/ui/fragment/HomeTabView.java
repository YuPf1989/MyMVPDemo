package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseNolayoutListFragment;
import com.rain.mymvpdemo.contract.HomeTabContract;
import com.rain.mymvpdemo.presenter.HomeTabPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class HomeTabView extends BaseNolayoutListFragment implements HomeTabContract.View {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.search)
    ImageView search;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    private HomeTabPresenter presenter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        presenter = new HomeTabPresenter();
        presenter.attachView(this);
    }

    public static HomeTabView newInstance() {
        return new HomeTabView();
    }

    @Override
    public void fetchData() {
        super.fetchData();
        onShowLoading();
        presenter.doLoadData();
    }

    @Override
    public BaseQuickAdapter setAdapter() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.search)
    public void onViewClicked() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public RecyclerView setRecycler() {
        return recyclerView;
    }

    @Override
    public SwipeRefreshLayout setSwipe() {
        return swipe;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
