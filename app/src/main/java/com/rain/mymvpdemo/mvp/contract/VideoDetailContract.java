package com.rain.mymvpdemo.mvp.contract;

import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.base.IBaseView;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/12 10:53
 * Description:
 */
public interface VideoDetailContract {
    interface View extends IBaseView {
        /**
         * 进行播放
         */
        void setVideo(String url);

        /**
         * 设置视频信息
         */
        void setVideoInfo(HomeBean.IssueListBean.ItemListBean videoInfo);

        void setRelatedVideo(List<HomeBean.IssueListBean.ItemListBean> videos);

        /**
         * 设置背景
         */
        void setBackground(String url);
    }

    interface Presenter extends IBasePresenter {
        /**
         * 加载视频信息
         */
        void loadVideoInfo(HomeBean.IssueListBean.ItemListBean itemInfo);

        /**
         * 请求相关的视频数据
         */
        void requestRelatedVideo(Long id);
    }

}
