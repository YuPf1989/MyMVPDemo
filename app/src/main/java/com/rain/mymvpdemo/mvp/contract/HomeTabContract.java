package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBaseListView;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.base.ILoadMoreView;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/31 11:53
 * Description:
 */
public interface HomeTabContract {
    interface View extends IBaseView,ILoadMoreView {
        void setBannerData(List<HomeBean.IssueListBean.ItemListBean> bannerData);
        void setLoadData(List<?> list);
    }

    interface Presenter extends IBasePresenter {
        void doLoadData(int num);
        void doRefresh();
        void doLoadMoreData();
    }

}
