package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface CategoryContract {
    interface View extends IBaseView {
        void setLoadData(List<?> list);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
    }
}
