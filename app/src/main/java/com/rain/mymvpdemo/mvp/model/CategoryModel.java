package com.rain.mymvpdemo.mvp.model;

import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.net.RetrofitHelper;
import com.rain.mymvpdemo.rx.scheduler.SchedulerUtils;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Author:rain
 * Date:2018/6/7 10:27
 * Description:
 */
public class CategoryModel {
    public static Observable<ArrayList<CategoryBean>> getCategoryData(){
        return RetrofitHelper.getInstance().getRetrofitService()
                .getCategory()
                .compose(SchedulerUtils.<ArrayList<CategoryBean>>ioToMain());
    }
}
