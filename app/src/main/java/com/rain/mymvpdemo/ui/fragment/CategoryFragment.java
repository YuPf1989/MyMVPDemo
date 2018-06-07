package com.rain.mymvpdemo.ui.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.classic.common.MultipleStatusView;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.base.LazyLoadFragment;
import com.rain.mymvpdemo.mvp.contract.CategoryContract;
import com.rain.mymvpdemo.mvp.model.entity.CategoryBean;
import com.rain.mymvpdemo.mvp.presenter.CategoryPresenter;
import com.rain.mymvpdemo.net.Exception.ErrorStatus;
import com.rain.mymvpdemo.ui.adapter.CategoryAdapter;
import com.rain.mymvpdemo.util.DisplayUtil;
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
public class CategoryFragment extends LazyLoadFragment implements CategoryContract.View {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.multipleStatusView)
    MultipleStatusView multipleStatusView;
    Unbinder unbinder;
    private CategoryPresenter presenter;
    private CategoryAdapter adapter;
    private static final String TAG  = "CategoryFragment";

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

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
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
        mLayoutStatusView = multipleStatusView;
        presenter = new CategoryPresenter();
        presenter.attachView(this);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int childPosition = parent.getChildPosition(view);
                int offset = DisplayUtil.dip2px(getActivity(), 2f);
                if (childPosition % 2 == 0) {
                    outRect.set(0, offset, offset, offset);
                } else {
                    outRect.set(offset, offset, 0, offset);
                }
            }
        });
        adapter = new CategoryAdapter(R.layout.item_category, null);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.showToast("position:"+position);
            }
        });
        mRecyclerView.setAdapter(adapter);
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
    public void onSetAdapterData(List<?> list) {
        multipleStatusView.showContent();
        adapter.setNewData((List<CategoryBean>) list);
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
}
