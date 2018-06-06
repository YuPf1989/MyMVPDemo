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

        // 数据当次请求完成，不代表数据全部加载完毕
        void onLoadComplete();
    }

    interface Presenter extends IBasePresenter {
        void doLoadData(int num);
        void doRefresh();
        void doLoadMoreData();
    }

}
