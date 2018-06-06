package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.banner.GlideImageLoader;
import com.rain.mymvpdemo.base.BaseFragment;
import com.rain.mymvpdemo.mvp.contract.HomeTabContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.mvp.presenter.HomeTabPresenter;
import com.rain.mymvpdemo.ui.adapter.HomeAdapter;
import com.rain.mymvpdemo.util.TimeUtils;
import com.rain.mymvpdemo.util.ToastUtil;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
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
public class HomeTabView extends BaseFragment implements HomeTabContract.View, OnRefreshListener {
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
    SmartRefreshLayout swipe;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    private HomeTabPresenter presenter;

    private int num = 1;
    private HomeAdapter homeAdapter;
    private Banner banner;
    private static final String TAG = "HomeTabView";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void fetchData() {
        onShowLoading();
        presenter.doLoadData(num);
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
        unbinder.unbind();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_tab;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mLayoutStatusView = multipleStatusView;
        presenter = new HomeTabPresenter();
        presenter.attachView(this);
        initRecycler();
        initBanner();
    }

    private void initBanner() {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_home_banner, null);
        banner = inflate.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.NUM_INDICATOR_TITLE);
        banner.setBannerAnimation(Transformer.Accordion);
        homeAdapter.addHeaderView(inflate);
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        homeAdapter = new HomeAdapter(null);
        homeAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // 处理toolbar
                int firstVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                if (firstVisibleItemPosition == 0) {
                    toolbar.setBackgroundResource(R.color.transparent);
                    title.setText("");
                    search.setImageResource(R.drawable.ic_action_search_white);
                } else {
                    List<HomeBean.IssueListBean.ItemListBean> data = homeAdapter.getData();
                    if (data.size() > 1) {
                        toolbar.setBackgroundResource(R.color.color_title_bg);
                        HomeBean.IssueListBean.ItemListBean item = data.get(firstVisibleItemPosition - 1);
                        if ("textHeader".equals(item.getType())) {
                            title.setText(item.getData().getText());
                        } else {
                            title.setText(TimeUtils.simpleDateFormat(item.getData().getDate()));
                        }
                        search.setImageResource(R.drawable.ic_action_search_black);
                    }
                }
            }
        });
        swipe.setOnRefreshListener(this);
        // 内容随swipe偏移
        swipe.setEnableHeaderTranslationContent(true);
        MaterialHeader refreshHeader = (MaterialHeader) swipe.getRefreshHeader();
        // 显示下拉背景
        refreshHeader.setShowBezierWave(true);
        swipe.setPrimaryColorsId(R.color.lineColor, R.color.color_title_bg);
        homeAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.doLoadMoreData();
            }
        }, recyclerView);

    }

    public static HomeTabView newInstance() {
        return new HomeTabView();
    }

    @Override
    public void onLoadEnd() {

    }

    @Override
    public void setLoadMoreData(List<?> list) {
        homeAdapter.addData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @OnClick(R.id.search)
    public void onViewClicked() {

    }

    @Override
    public void onSetAdapterData(List<?> list) {
        // TODO: 2018/6/5  
        mLayoutStatusView.showContent();
        homeAdapter.setNewData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @Override
    public void onShowLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.autoRefresh();
            }
        });
    }

    @Override
    public void onHideLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.finishRefresh();
            }
        });
    }

    @Override
    public void onShowNetError(String msg, int err_code) {
        ToastUtil.showToast(msg + ":" + err_code);
        homeAdapter.loadMoreFail();
        if (err_code == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView.showNoNetwork();
        } else {
            mLayoutStatusView.showError();
        }
    }

    @Override
    public void setBannerData(List<HomeBean.IssueListBean.ItemListBean> bannerData) {
        ArrayList<String> urls = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        for (int i = 0; i < bannerData.size(); i++) {
            urls.add(bannerData.get(i).getData().getCover().getFeed());
            titles.add(bannerData.get(i).getData().getTitle());
        }
        banner.setImages(urls)
                .setBannerTitles(titles)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    @Override
    public void onLoadComplete() {
        homeAdapter.loadMoreComplete();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        presenter.doLoadData(1);
    }
}
