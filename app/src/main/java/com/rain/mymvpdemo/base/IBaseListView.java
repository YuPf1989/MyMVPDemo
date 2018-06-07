package com.rain.mymvpdemo.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.trello.rxlifecycle2.LifecycleTransformer;

import java.util.List;

/**
 * Created by Meiji on 2017/7/5.
 */

public interface IBaseListView extends IBaseView {

    /**
     * 设置适配器数据
     */
    void onSetAdapterData(List<?> list);

    /**
     * 加载完毕
     */
    void onLoadEnd();

    // 数据当次请求完成，不代表数据全部加载完毕
    void onLoadComplete();

    void setLoadMoreData(List<?> list);
}
