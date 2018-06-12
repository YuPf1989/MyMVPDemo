package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/12 10:49
 * Description:
 */
public class VideoDetailModel {
    public static Observable<HomeBean.IssueListBean> requestRelatedData(Long id){
        return RetrofitHelper.getInstance().getRetrofitService().getRelatedData(id)
                .compose(SchedulerUtils.ioToMain());
    }
}
