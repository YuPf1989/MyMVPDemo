package com.rain.mymvpdemo.mvp.presenter;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;

import com.rain.mymvpdemo.base.BasePresenter;
import com.rain.mymvpdemo.base.IBasePresenter;
import com.rain.mymvpdemo.mvp.contract.VideoDetailContract;
import com.rain.mymvpdemo.mvp.model.VideoDetailModel;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.net.Exception.ExceptionHandle;
import com.rain.mymvpdemo.util.DisplayUtil;
import com.rain.mymvpdemo.util.NetworkUtils;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Author:rain
 * Date:2018/6/12 10:51
 * Description:
 */
public class VideoDetailPresenter extends BasePresenter implements VideoDetailContract.Presenter {
    private static final String TAG  = "VideoDetailPresenter";


    // 加载视频相关数据
    @Override
    public void loadVideoInfo(HomeBean.IssueListBean.ItemListBean itemInfo) {
        checkViewAttached();
        List<HomeBean.IssueListBean.ItemListBean.DataBean.PlayInfoBean> playInfo = itemInfo.getData().getPlayInfo();
        boolean wifi = NetworkUtils.isWifi(((Activity) view));
        if (wifi) { // 是wifi就选择高清
            if (playInfo.size() > 1) {
                for (HomeBean.IssueListBean.ItemListBean.DataBean.PlayInfoBean bean :
                        playInfo) {
                    if (bean.getType().equals("high")) {
                        ((VideoDetailContract.View) view).setVideo(bean.getUrl());
                    }
                }
            } else {
                ((VideoDetailContract.View) view).setVideo(itemInfo.getData().getPlayUrl());
            }
        } else { // 标清
            ((VideoDetailContract.View) view).setVideo(itemInfo.getData().getPlayUrl());
        }
        // 设置背景
        String backgroundUrl = itemInfo.getData().getCover().getBlurred()
                + "/thumbnail/"
                + (DisplayUtil.getScreenHeight((Context) view) - DisplayUtil.dip2px((Context) view, 250f))
                + "x"
                + DisplayUtil.getScreenWidth((Context) view);
        ((VideoDetailContract.View) view).setBackground(backgroundUrl);
        ((VideoDetailContract.View) view).setVideoInfo(itemInfo);
    }

    // 请求最近的视频列表
    @Override
    public void requestRelatedVideo(Long id) {
        Disposable disposable = VideoDetailModel.requestRelatedData(id)
                .subscribe(new Consumer<HomeBean.IssueListBean>() {
                    @Override
                    public void accept(HomeBean.IssueListBean issueListBean) throws Exception {
                        view.onHideLoading();
                        List<HomeBean.IssueListBean.ItemListBean> itemList = issueListBean.getItemList();
                        ((VideoDetailContract.View) view).setRelatedVideo(itemList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onHideLoading();
                        view.onShowNetError(ExceptionHandle.handleException(throwable), ExceptionHandle.getErrorCode());
                    }
                });
        this.addSubscription(disposable);
    }
}
