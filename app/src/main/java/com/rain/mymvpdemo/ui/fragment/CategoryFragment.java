package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.base.BaseListFragment;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/6 9:48
 * Description:
 */
public class CategoryFragment extends BaseListFragment {
    @Override
    protected BaseQuickAdapter setAdapter() {
        return null;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setLoadMoreData(List<?> list) {

    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {

    }

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }
}
