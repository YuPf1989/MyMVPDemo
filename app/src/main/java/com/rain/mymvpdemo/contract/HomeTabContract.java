package com.rain.mymvpdemo.contract;

import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.model.entity.HomeBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface HomeTabContract {
    interface View extends IBaseListView {
        void setBannerData(List<HomeBean.IssueListBean.ItemListBean> bannerData);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData(int num);
        void doRefresh();
        void doLoadMoreData();
    }

}
