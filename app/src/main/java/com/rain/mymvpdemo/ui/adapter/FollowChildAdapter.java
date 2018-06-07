package com.rain.mymvpdemo.ui.adapter;

import android.support.annotation.Nullable;
import android.view.View;
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
 * Date:2018/6/6 16:02
 * Description:
 * recycler中的子recycler的adapter
 */
public class FollowChildAdapter extends BaseQuickAdapter<HomeBean.IssueListBean.ItemListBean,BaseViewHolder> {
    public FollowChildAdapter(int layoutResId, @Nullable List<HomeBean.IssueListBean.ItemListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean data = item.getData();
        // 标题
        helper.setText(R.id.tv_title, data.getTitle());
        // 设置tag
        List<HomeBean.IssueListBean.ItemListBean.DataBean.TagsBean> tags = data.getTags();
        StringBuffer tag_buf = new StringBuffer("#");
        for (HomeBean.IssueListBean.ItemListBean.DataBean.TagsBean tag :
                tags) {
            tag_buf.append(tag.getName()).append("/");
        }
        tag_buf.append(TimeUtils.durationFormat(data.getDuration()));
        helper.setText(R.id.tv_tag, tag_buf);
        // 封面
        GlideApp.with(mContext)
                .load(data.getCover().getFeed())
                .transition(DrawableTransitionOptions.withCrossFade())
                .placeholder(R.drawable.placeholder_banner)
                .into((ImageView) helper.getView(R.id.iv_cover_feed));

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                // TODO: 2018/6/6 跳转到视频播放界面
            }
        });
    }


}
