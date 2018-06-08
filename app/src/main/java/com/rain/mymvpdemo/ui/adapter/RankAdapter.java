package com.rain.mymvpdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.util.TimeUtils;

import java.util.List;

/**
 * Author:rain
 * Date:2018/5/11 17:28
 * Description:
 */
public class RankAdapter extends BaseQuickAdapter<HomeBean.IssueListBean.ItemListBean,BaseViewHolder> {
    public RankAdapter(int layoutResId, @Nullable List<HomeBean.IssueListBean.ItemListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean data = item.getData();
        HomeBean.IssueListBean.ItemListBean.DataBean.HeaderBean header = data.getHeader();
        // 设置标题
        helper.setText(R.id.tv_title, data.getTitle());
        // 设置描述
        String time = TimeUtils.durationFormat(data.getDuration());
        String category = data.getCategory();
        helper.setText(R.id.tv_tag, "#"+category+"/"+time);
        // 封面
        GlideApp.with(mContext)
                .load(data.getCover().getFeed())
                .transition(DrawableTransitionOptions.withCrossFade()).placeholder(R.drawable.placeholder_banner)
                .into((ImageView) helper.getView(R.id.iv_image));
    }
}
