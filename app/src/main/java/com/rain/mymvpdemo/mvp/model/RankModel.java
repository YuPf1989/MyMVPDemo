package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/7 16:45
 * Description:
 */
public class RankModel {
    public static Observable<HomeBean.IssueListBean> getRankList(String url){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getIssueData(url)
                .compose(SchedulerUtils.<HomeBean.IssueListBean>ioToMain());
    }
}
