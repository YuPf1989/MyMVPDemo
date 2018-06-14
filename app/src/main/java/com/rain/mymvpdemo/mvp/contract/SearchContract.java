package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.base.ILoadMoreView;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;

import java.util.ArrayList;

/**
 * Author:rain
 * Date:2018/6/13 16:05
 * Description:
 */
public interface SearchContract {
    interface View extends IBaseView,ILoadMoreView {
        /**
         * 设置热门关键词数据
         */
        void setHotWordData(ArrayList<String> string);

        /**
         * 设置搜索关键词返回的结果
         */
        void setSearchResult(HomeBean.IssueListBean issue);

        /**
         * 设置空 View
         */
        void setEmptyView();

    }

    interface Presenter extends IBasePresenter {
        /**
         * 获取热门关键字的数据
         */
        void requestHotWordData();

        /**
         * 查询搜索
         */
        void querySearchData(String words);

        /**
         * 加载更多
         */
        void loadMoreData();
    }

}
