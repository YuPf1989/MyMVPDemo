package com.rain.mymvpdemo.rx.scheduler;

import android.support.annotation.NonNull;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:rain
 * Date:2018/5/31 17:07
 * Description:
 */
public class SchedulerUtils {
    public static @NonNull <T>ObservableTransformer ioToMain() {
        return new BaseScheduler<T>(Schedulers.io(), AndroidSchedulers.mainThread());
    }

    public static @NonNull ObservableTransformer computationMainScheduler() {
        return new BaseScheduler(Schedulers.computation(), AndroidSchedulers.mainThread());
    }

    public static @NonNull ObservableTransformer newThreadToMain() {
        return new BaseScheduler(Schedulers.newThread(), AndroidSchedulers.mainThread());
    }

    public static @NonNull ObservableTransformer singleToMain() {
        return new BaseScheduler(Schedulers.single(), AndroidSchedulers.mainThread());
    }

    public static @NonNull ObservableTransformer trampolineToMain() {
        return new BaseScheduler(Schedulers.trampoline(), AndroidSchedulers.mainThread());
    }


}
