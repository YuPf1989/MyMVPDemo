package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface HotContract {
    interface View extends IBaseView {
        void onSetData(TabInfoBean infoBean);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData();
    }
}
