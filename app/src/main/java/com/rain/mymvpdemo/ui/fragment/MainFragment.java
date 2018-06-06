package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.BaseListFragment;
import com.rain.mymvpdemo.contract.MyContract;
import com.rain.mymvpdemo.presenter.MyPresenter;
import com.rain.mymvpdemo.ui.adapter.MySimpleAdapter;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/29 16:17
 * Description:
 * 这是一个使用范例
 */
public class MainFragment extends BaseListFragment implements MyContract.View{
    private static final String TAG  = "MainFragment";
    private MyContract.Presenter presenter;

    @Override
    public void onSetAdapterData(List list) {
        adapter.setNewData(list);
    }

    @Override
    public BaseQuickAdapter setAdapter() {
        return new MySimpleAdapter(R.layout.list_item, null);
    }

    @Override
    public void setLoadMoreData(List<?> list) {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        presenter = new MyPresenter(this);
        presenter.attachView(this);
    }

    @Override
    public void fetchData() {
        super.fetchData();
        onShowLoading();
        presenter.doLoadData();
    }

    @Override
    public boolean prepareFetchData() {
        return super.prepareFetchData(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public void onRefresh() {
        int position = ((LinearLayoutManager) recycler.getLayoutManager()).findFirstVisibleItemPosition();
        if (position == 0) {
            presenter.doRefresh();
        } else {
            recycler.scrollToPosition(15);
            recycler.smoothScrollToPosition(0);
        }
    }

    @Override
    public void onShowNetError(String err_msg, int err_code) {

    }
}
