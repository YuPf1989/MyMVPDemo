package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.banner.GlideImageLoader;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.contract.HomeTabContract;
import com.rain.mymvpdemo.model.entity.HomeBean;
import com.rain.mymvpdemo.presenter.HomeTabPresenter;
import com.rain.mymvpdemo.ui.adapter.HomeAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class HomeTabView extends BaseFragment implements HomeTabContract.View, SwipeRefreshLayout.OnRefreshListener {
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

    private int num = 1;
    private HomeAdapter homeAdapter;
    private Banner banner;
    private static final String TAG = "HomeTabView";

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        presenter = new HomeTabPresenter();
        presenter.attachView(this);
        initRecycler();
        initBanner();
        onShowLoading();
        presenter.doLoadData(num);
    }

    private void initBanner() {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_home_banner, null);
        banner = inflate.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);

        homeAdapter.addHeaderView(inflate);
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        homeAdapter = new HomeAdapter(null);
        recyclerView.setAdapter(homeAdapter);
        swipe.setOnRefreshListener(this);
    }

    public static HomeTabView newInstance() {
        return new HomeTabView();
    }

    @Override
    public BaseQuickAdapter setAdapter() {
        return null;
    }

    @Override
    public void onShowNoMore() {

    }

    @Override
    public void setLoadMoreData(List<?> list) {

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
        presenter.doLoadData(1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onSetAdapterData(List<?> list) {
        homeAdapter.setNewData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @Override
    public void onShowLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
            }
        });
    }

    @Override
    public void onHideLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(false);
            }
        });
    }

    @Override
    public void onShowNetError() {

    }

    @Override
    public void setBannerData(List<HomeBean.IssueListBean.ItemListBean> bannerData) {
        ArrayList<String> urls = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < bannerData.size(); i++) {
            urls.add(bannerData.get(i).getData().getCover().getFeed());
            titles.add(bannerData.get(i).getData().getTitle());
        }
        banner.setImages(urls);
        banner.setBannerTitles(titles);
    }
}
