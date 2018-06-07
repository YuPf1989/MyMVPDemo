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
import com.rain.mymvpdemo.mvp.contract.RankContract;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.mvp.presenter.RankPresenter;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.ui.adapter.FollowAdapter;
import com.rain.mymvpdemo.ui.adapter.RankAdapter;
import com.rain.mymvpdemo.util.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:rain
 * Date:2018/5/15 9:33
 * Description:
 */
public class RankFragment extends LazyLoadFragment implements RankContract.View {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    Unbinder unbinder;
    private String url;
    private RankPresenter presenter;
    private RankAdapter adapter;

    @Override
    public void fetchData() {
        onShowLoading();
        presenter.doLoadData(url);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_recyclerview;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        url = (String) getArguments().get("url");
        mLayoutStatusView = multipleStatusView;
        presenter = new RankPresenter();
        presenter.attachView(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RankAdapter(R.layout.item_category_detail, null);
        mRecyclerView.setAdapter(adapter);
    }

    public static RankFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putCharSequence("url", url);
        RankFragment fragment = new RankFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onSetAdapterData(List<?> list) {
        onHideLoading();
        adapter.setNewData((List<HomeBean.IssueListBean.ItemListBean>) list);
    }

    @Override
    public void onLoadEnd() {

    }

    @Override
    public void onLoadComplete() {

    }

    @Override
    public void setLoadMoreData(List<?> list) {

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
