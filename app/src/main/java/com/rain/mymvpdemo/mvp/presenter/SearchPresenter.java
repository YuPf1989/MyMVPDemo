package com.rain.mymvpdemo.mvp.presenter;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.SearchContract;
import com.rain.mymvpdemo.mvp.model.SearchModel;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/13 16:07
 * Description:
 */
public class SearchPresenter extends BasePresenter implements SearchContract.Presenter {
    private String nextPageUrl;

    @Override
    public void requestHotWordData() {
        Disposable disposable = SearchModel.getHotWord()
                .subscribe(new Consumer<ArrayList<String>>() {
                    @Override
                    public void accept(ArrayList<String> strings) throws Exception {
                        ((SearchContract.View) view).setHotWordData(strings);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onShowNetError(ExceptionHandle.handleException(throwable), ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }

    @Override
    public void querySearchData(String words) {
        view.onShowLoading();
        Disposable disposable = SearchModel.getSearchData(words)
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean issueListBean) throws Exception {
                        view.onHideLoading();
                        nextPageUrl = issueListBean.getNextPageUrl();
                        List<HomeBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
                        if (issueListBean.getCount() > 0 && itemList.size() > 0) {
                            ((SearchContract.View) view).setSearchResult(issueListBean);
                        } else {
                            ((SearchContract.View) view).setEmptyView();
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onHideLoading();
                        view.onShowNetError(ExceptionHandle.handleException(throwable), ExceptionHandle.getErrorCode());
                    }
                });

        this.addSubscription(disposable);
    }

    @Override
    public void loadMoreData() {
        if (nextPageUrl == null) {
            ((SearchContract.View) view).onLoadEnd();
            return;
        }
        Disposable disposable = SearchModel.loadMoreData(nextPageUrl)
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean issueListBean) throws Exception {
                        nextPageUrl = issueListBean.getNextPageUrl();
                        ((SearchContract.View) view).onLoadComplete();
                        ((SearchContract.View) view).setLoadMoreData(issueListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ((SearchContract.View) view).onLoadFail();
                    }
                });

        this.addSubscription(disposable);
    }
}
