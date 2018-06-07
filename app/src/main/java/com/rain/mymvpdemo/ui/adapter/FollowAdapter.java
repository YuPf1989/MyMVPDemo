package com.rain.mymvpdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/11 17:28
 * Description:
 */
public class FollowAdapter extends BaseQuickAdapter<HomeBean.IssueListBean.ItemListBean,BaseViewHolder> {
    public FollowAdapter(int layoutResId, @Nullable List<HomeBean.IssueListBean.ItemListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean data = item.getData();
        HomeBean.IssueListBean.ItemListBean.DataBean.HeaderBean header = data.getHeader();
        // 设置标题
        helper.setText(R.id.tv_title, header.getTitle());
        // 设置描述
        helper.setText(R.id.tv_desc, header.getDescription());
        // 设置头像
        GlideApp.with(mContext)
                .load(header.getIcon())
                .circleCrop()
                .into((ImageView) helper.getView(R.id.iv_avatar));
        // 设置子recycler
        List<HomeBean.IssueListBean.ItemListBean> itemList = data.getItemList();
        RecyclerView recyclerView = helper.getView(R.id.fl_recyclerView);
        setChildRecycler(recyclerView,itemList);
    }

    private void setChildRecycler(RecyclerView recyclerView,List<HomeBean.IssueListBean.ItemListBean> itemList ) {
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        FollowChildAdapter childAdapter = new FollowChildAdapter(R.layout.item_follow_horizontal, itemList);
        recyclerView.setAdapter(childAdapter);
    }

}
