package com.rain.mymvpdemo.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/17 16:02
 * Description:
 * 一个基本的带刷新和recycler的fragment
 * 只需要设置adapter和数据源
 * 其他view需要自己设置
 */
public abstract class BaseNolayoutListFragment extends LazyLoadFragment implements SwipeRefreshLayout.OnRefreshListener, IBaseNoLayoutListView {
    protected RecyclerView recycler;
    protected SwipeRefreshLayout swipe;
    protected BaseQuickAdapter adapter;

    @Override
    public void fetchData() {
        adapter.setNewData(null);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        recycler = setRecycler();
        swipe = setSwipe();
        adapter = setAdapter();
        initRecycler();
    }

    private void initRecycler() {
        recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        swipe.setOnRefreshListener(this);
    }

    @Override
    public void onShowLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(true);
            }
        });
    }

    @Override
    public void onHideLoading() {
        swipe.post(new Runnable() {
            @Override
            public void run() {
                swipe.setRefreshing(false);
            }
        });
    }

    @Override
    public void onShowNetError() {

    }

    @Override
    public void onSetAdapterData(List<?> list) {
        adapter.setNewData(list);
    }

    @Override
    public void onShowNoMore() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
