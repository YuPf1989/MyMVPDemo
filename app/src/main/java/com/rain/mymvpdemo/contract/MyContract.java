package com.rain.mymvpdemo.contract;


import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;

/**
 * Author:rain
 * Date:2018/5/29 15:50
 * Description:
 */
public interface MyContract {
    interface View extends IBaseListView {
        /**
         * 请求数据
         */
        void onLoadData();

        /**
         * 刷新
         */
        void onRefresh();
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
        void doRefresh();
    }
}
