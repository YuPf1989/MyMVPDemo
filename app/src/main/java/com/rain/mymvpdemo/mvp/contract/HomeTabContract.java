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
public interface HomeTabContract {
    interface View extends IBaseListView {
        void setBannerData(List<HomeBean.IssueListBean.ItemListBean> bannerData);

        void onLoadMoreFail(String err_msg,int err_code);

    }

    interface Presenter extends IBasePresenter {
        void doLoadData(int num);
        void doRefresh();
        void doLoadMoreData();
    }

}
