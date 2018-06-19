package com.rain.mymvpdemo.mvp.presenter;

import android.annotation.SuppressLint;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.HomeTabContract;
import com.rain.mymvpdemo.mvp.model.HomeModel;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;

import java.util.Iterator;
import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Author:rain
 * Date:2018/5/31 11:57
 * Description:
 */
public class HomeTabPresenter extends BasePresenter implements HomeTabContract.Presenter {

    private static final String TAG = "HomeTabPresenter";

    private List<HomeBean.IssueListBean.ItemListBean> bannerList; // banner数据

    private String nextPageUrl;

    /**
     * 获取首页精选数据 banner 加 一页数据
     */
    @SuppressLint("CheckResult")
    @Override
    public void doLoadData(final int num) {
        checkViewAttached();
        Disposable disposable = HomeModel.requestHomeData(num)
                .flatMap(new Function<HomeBean, ObservableSource<HomeBean>>() {
                    @Override
                    public ObservableSource<HomeBean> apply(HomeBean homeBean) throws Exception {
                        bannerList = homeBean.getIssueList().get(0).getItemList();
                        Iterator<HomeBean.IssueListBean.ItemListBean> iterator = bannerList.iterator();
                        //过滤掉 Banner2(包含广告,等不需要的 Type), 具体查看接口分析
                        while (iterator.hasNext()) {
                            HomeBean.IssueListBean.ItemListBean item = iterator.next();
                            if (item.getType().equals("banner2") || item.getType().equals("horizontalScrollCard")) {
                                iterator.remove();
                            }
                        }
                        ((HomeTabContract.View) view).setBannerData(bannerList);
                        //根据 nextPageUrl 请求下一页数据
                        return HomeModel.loadMoreData(homeBean.getNextPageUrl());
                    }
                })
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        view.onHideLoading();
                        nextPageUrl = homeBean.getNextPageUrl();
                        List<HomeBean.IssueListBean.ItemListBean> newBannerList = homeBean.getIssueList().get(0).getItemList();
                        Iterator<HomeBean.IssueListBean.ItemListBean> iterator = newBannerList.iterator();
                        //过滤掉 Banner2(包含广告,等不需要的 Type), 具体查看接口分析
                        while (iterator.hasNext()) {
                            HomeBean.IssueListBean.ItemListBean item = iterator.next();
                            if (item.getType().equals("banner2") || item.getType().equals("horizontalScrollCard")) {
                                iterator.remove();
                            }
                        }
                        view.onHideLoading();
                        ((HomeTabContract.View) view).setLoadData(newBannerList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onHideLoading();
                        view.onShowNetError(ExceptionHandle.handleException(throwable),ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }

    @Override
    public void doLoadMoreData() {
        if (nextPageUrl == null) {
            ((HomeTabContract.View) view).onLoadEnd();
        }
        Disposable disposable = HomeModel.loadMoreData(nextPageUrl)
                .subscribe(new Consumer<HomeBean>() {
                    @Override
                    public void accept(HomeBean homeBean) throws Exception {
                        nextPageUrl = homeBean.getNextPageUrl();
                        List<HomeBean.IssueListBean.ItemListBean> newBannerList = homeBean.getIssueList().get(0).getItemList();
                        Iterator<HomeBean.IssueListBean.ItemListBean> iterator = newBannerList.iterator();
                        //过滤掉 Banner2(包含广告,等不需要的 Type), 具体查看接口分析
                        while (iterator.hasNext()) {
                            HomeBean.IssueListBean.ItemListBean item = iterator.next();
                            if (item.getType().equals("banner2") || item.getType().equals("horizontalScrollCard")) {
                                iterator.remove();
                            }
                        }
                        ((HomeTabContract.View) view).setLoadMoreData(newBannerList);
                        ((HomeTabContract.View) view).onLoadComplete();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onHideLoading();
                        ((HomeTabContract.View) view).onLoadFail();
                    }
                });
        this.addSubscription(disposable);
    }

    @Override
    public void doRefresh() {
        doLoadData(1);
    }
}
