package com.rain.mymvpdemo.mvp.presenter;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.CategoryContract;
import com.rain.mymvpdemo.mvp.model.CategoryModel;
import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/7 10:20
 * Description:
 */
public class CategoryPresenter extends BasePresenter implements CategoryContract.Presenter {
    @Override
    public void doLoadData() {
        checkViewAttached();
        Disposable disposable = CategoryModel.getCategoryData()
                .subscribe(new Consumer<ArrayList<CategoryBean>>() {
                    @Override
                    public void accept(ArrayList<CategoryBean> categoryBeans) throws Exception {
                        ((CategoryContract.View) view).onSetAdapterData(categoryBeans);
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
