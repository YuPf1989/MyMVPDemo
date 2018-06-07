package com.rain.mymvpdemo.mvp.presenter;

import android.util.Log;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.FollowContract;
import com.rain.mymvpdemo.mvp.model.FollowModel;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/6 11:29
 * Description:
 */
public class FollowPresenter extends BasePresenter implements FollowContract.Presenter{

    private String nextPageUrl;
    private static final String TAG  = "FollowPresenter";

    @Override
    public void doLoadData() {
        checkViewAttached();
        Disposable disposable = FollowModel.getFollowList()
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean issueListBean) throws Exception {
                        nextPageUrl = issueListBean.getNextPageUrl();
                        List<HomeBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
                        ((FollowContract.View) view).onSetAdapterData(itemList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable e) throws Exception {
                        view.onShowNetError(ExceptionHandle.handleException(e),ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }

    @Override
    public void doLoadMoreData() {
        Log.e(TAG, "doLoadMoreData: "+nextPageUrl);
        if (nextPageUrl == null) {
            ((FollowContract.View) view).onLoadEnd();
            return;
        }
        Disposable disposable = FollowModel.loadMoreData(nextPageUrl)
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean issueListBean) throws Exception {
                        nextPageUrl = issueListBean.getNextPageUrl();
                        List<HomeBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
                        ((FollowContract.View) view).setLoadMoreData(itemList);
                        ((FollowContract.View) view).onLoadComplete();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable e) throws Exception {
                        ((FollowContract.View) view).onLoadMoreError(ExceptionHandle.handleException(e),ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }
}
