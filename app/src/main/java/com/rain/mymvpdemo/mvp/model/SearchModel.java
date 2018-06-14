package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/13 17:00
 * Description:
 */
public class SearchModel {
    public static Observable<HomeBean.IssueListBean> getSearchData(String query){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getSearchData(query)
                .compose(SchedulerUtils.ioToMain());
    }

    public static Observable<ArrayList<String>> getHotWord(){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getHotWord()
                .compose(SchedulerUtils.ioToMain());
    }

    public static Observable<HomeBean.IssueListBean> loadMoreData(String url) {
        return RetrofitHelper.getInstance().getRetrofitService()
                .getIssueData(url)
                .compose(SchedulerUtils.ioToMain());
    }
}
