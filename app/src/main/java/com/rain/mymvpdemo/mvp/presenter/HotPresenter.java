package com.rain.mymvpdemo.mvp.presenter;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.mvp.contract.CategoryContract;
import com.rain.mymvpdemo.mvp.contract.HotContract;
import com.rain.mymvpdemo.mvp.model.CategoryModel;
import com.rain.mymvpdemo.mvp.model.HotModel;
import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;
import com.rain.mymvpdemo.net.MyObserver.MyObserver2;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/7 10:20
 * Description:
 */
public class HotPresenter extends BasePresenter implements HotContract.Presenter {
    @Override
    public void doLoadData() {
        checkViewAttached();
//        Disposable disposable = HotModel.getRankList()
//                .subscribe(new Consumer<TabInfoBean>() {
//                    @Override
//                    public void accept(TabInfoBean infoBean) throws Exception {
//                        ((HotContract.View) view).onSetData(infoBean);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable e) throws Exception {
//                        view.onShowNetError(ExceptionHandle.handleException(e),ExceptionHandle.getErrorCode());
//                    }
//                });

         HotModel.getRankList()
                .subscribe(new MyObserver2<TabInfoBean>(view,true,this) {
                    @Override
                    public void onNext(TabInfoBean infoBean) {
                        ((HotContract.View) view).onSetData(infoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.onShowNetError(ExceptionHandle.handleException(e),ExceptionHandle.getErrorCode());
                    }
                });
    }
}
