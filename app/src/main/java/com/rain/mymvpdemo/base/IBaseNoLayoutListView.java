package com.rain.mymvpdemo.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

/**
 * Created by Meiji on 2017/7/5.
 */

public interface IBaseNoLayoutListView extends IBaseListView {
    // 获取recycler对象
    RecyclerView setRecycler();

    // 获取swipe对象
    SwipeRefreshLayout setSwipe();
}
