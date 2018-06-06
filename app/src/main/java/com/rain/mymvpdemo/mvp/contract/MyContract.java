package com.rain.mymvpdemo.mvp.contract;


import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;

/**
 * Author:rain
 * Date:2018/5/29 15:50
 * Description:
 */
public interface MyContract {
    interface View extends IBaseListView {
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
        void doRefresh();
    }
}
