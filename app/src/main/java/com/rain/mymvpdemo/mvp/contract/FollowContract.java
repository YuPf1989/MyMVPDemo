package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface FollowContract {
    interface View extends IBaseListView {
        void onLoadMoreError(String err_msg,int err_code);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
        void doLoadMoreData();
    }
}
