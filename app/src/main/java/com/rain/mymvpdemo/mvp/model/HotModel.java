package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/7 10:27
 * Description:
 */
public class HotModel {
    public static Observable<TabInfoBean> getRankList(){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getRankList()
                .compose(SchedulerUtils.<TabInfoBean>ioToMain());
    }
}
