package com.rain.mymvpdemo.net.MyObserver;

import com.rain.mymvpdemo.MyApplication;
import com.rain.mymvpdemo.net.Exception.ApiErrorHelper;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Author:rain
 * Date:2017/11/13 14:20
 * Description:
 */

public abstract class MyObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }
    @Override
    public abstract void onNext(@NonNull T t);

    @Override
    public void onError(@NonNull Throwable e) {
        // 异常，统一交给该处理的类去处理
        ApiErrorHelper.handleCommonError(MyApplication.getInstance(), e);
    }

    @Override
    public void onComplete() {

    }
}
