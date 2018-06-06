package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/5/31 17:03
 * Description:
 */
public class HomeModel {
    /**
     * 获取首页 Banner 数据
     */
    public static Observable<HomeBean> requestHomeData(int num){
        return RetrofitHelper.getInstance().getRetrofitService().getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain());
    }

    /**
     * 加载更多
     */
    public static Observable<HomeBean> loadMoreData(String url){
        return RetrofitHelper.getInstance().getRetrofitService().getMoreHomeData(url)
                .compose(SchedulerUtils.ioToMain());
    }
}
