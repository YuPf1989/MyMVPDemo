package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.base.ILoadMoreView;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface FollowContract {
    interface View extends IBaseView,ILoadMoreView {
        void setLoadData(List<?> list);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
        void doLoadMoreData();
    }
}
