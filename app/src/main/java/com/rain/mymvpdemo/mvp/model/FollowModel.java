package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/6 11:11
 * Description:
 */
public class FollowModel {
    public static Observable<HomeBean.IssueListBean> getFollowList(){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getFollowInfo()
                .compose(SchedulerUtils.ioToMain());
    }

    public static Observable<HomeBean.IssueListBean> loadMoreData(String url){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getIssueData(url)
                .compose(SchedulerUtils.ioToMain());
    }
}
