package com.rain.mymvpdemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.LazyLoadFragment;
import com.rain.mymvpdemo.mvp.contract.FollowContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.FollowPresenter;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.ui.adapter.FollowAdapter;
import com.rain.mymvpdemo.util.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/6/6 9:48
 * Description:
 */
public class FollowFragment extends LazyLoadFragment implements FollowContract.View {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    Unbinder unbinder;
    private FollowPresenter presenter;
    private FollowAdapter followAdapter;

    public static FollowFragment newInstance() {
        return new FollowFragment();
    }

    @Override
    public void fetchData() {
        onShowLoading();
        presenter.doLoadData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        presenter = new FollowPresenter();
        presenter.attachView(this);
        mLayoutStatusView = multipleStatusView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        followAdapter = new FollowAdapter(R.layout.item_follow, null);
        followAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        followAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.doLoadMoreData();
            }
        },mRecyclerView);
        mRecyclerView.setAdapter(followAdapter);
    }

    @Override
    public void onSetAdapterData(List<?> list) {
        multipleStatusView.showContent();
        followAdapter.setNewData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @Override
    public void onLoadEnd() {
        followAdapter.loadMoreEnd();
    }

    @Override
    public void onLoadComplete() {
        followAdapter.loadMoreComplete();
    }

    @Override
    public void setLoadMoreData(List<?> list) {
        followAdapter.addData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @Override
    public void onShowLoading() {
        multipleStatusView.showLoading();
    }

    @Override
    public void onHideLoading() {
        multipleStatusView.showContent();
    }

    @Override
    public void onShowNetError(String msg, int err_code) {
        ToastUtil.showToast(msg + ":" + err_code);
        if (err_code == ErrorStatus.NETWORK_ERROR) {
            mLayoutStatusView.showNoNetwork();
        } else {
            mLayoutStatusView.showError();
        }
    }

    @Override
    public void onLoadMoreError(String msg,int err_code) {
        ToastUtil.showToast(msg + ":" + err_code);
        followAdapter.loadMoreFail();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenter.detachView();
    }
}
