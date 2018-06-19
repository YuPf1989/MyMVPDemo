package com.rain.mymvpdemo.mvp.presenter;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.CategoryContract;
import com.rain.mymvpdemo.mvp.contract.RankContract;
import com.rain.mymvpdemo.mvp.model.CategoryModel;
import com.rain.mymvpdemo.mvp.model.RankModel;
import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/7 10:20
 * Description:
 */
public class RankPresenter extends BasePresenter implements RankContract.Presenter {
    @Override
    public void doLoadData(String url) {
        checkViewAttached();
        Disposable disposable = RankModel.getRankList(url)
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean data) throws Exception {
                        List<HomeBean.IssueListBean.ItemListBean> itemList = data.getItemList();
                        ((RankContract.View) view).setLoadData(itemList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable e) throws Exception {
                        view.onShowNetError(ExceptionHandle.handleException(e),ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }
}
