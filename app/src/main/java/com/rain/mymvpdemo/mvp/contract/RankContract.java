package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.mvp.model.entity.TabInfoBean;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface RankContract {
    interface View extends IBaseListView {
    }

    interface Presenter extends IBasePresenter {
        void doLoadData(String url);
    }
}
