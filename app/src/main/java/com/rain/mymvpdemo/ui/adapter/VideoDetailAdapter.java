package com.rain.mymvpdemo.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rain.mymvpdemo.R;
import com.rain.mymvpdemo.glide.GlideApp;
import com.rain.mymvpdemo.mvp.model.entity.HomeBean;
import com.rain.mymvpdemo.util.TimeUtils;

import java.util.List;

/**
 * Author:rain
 * Date:2018/6/12 15:42
 * Description:
 */
public class VideoDetailAdapter extends BaseMultiItemQuickAdapter<HomeBean.IssueListBean.ItemListBean, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public VideoDetailAdapter(List<HomeBean.IssueListBean.ItemListBean> data) {
        super(data);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_video_text_card, R.layout.item_video_text_card);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_video_small_card, R.layout.item_video_small_card);
        addItemType(HomeBean.IssueListBean.ItemListBean.type_video_detail_info, R.layout.item_video_detail_info);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        if (helper.getAdapterPosition() == 0) {        // 视频详情
            setVideoDetailInfo(helper, item);
        } else if (item.getItemType() == HomeBean.IssueListBean.ItemListBean.type_video_text_card) { // 视频分类标题
            helper.setText(R.id.tv_text_card, item.getData().getText());
        } else if (item.getItemType() == HomeBean.IssueListBean.ItemListBean.type_video_small_card) {// 视频列表item
            GlideApp.with(mContext)
                    .load(item.getData().getCover().getDetail())
                    .placeholder(R.drawable.default_avatar)
                    .into((ImageView) helper.getView(R.id.iv_video_small_card));
            helper.setText(R.id.tv_title, item.getData().getTitle());
            String duratuion = TimeUtils.durationFormat(item.getData().getDuration());
            helper.setText(R.id.tv_tag, "#" + item.getData().getCategory() + "/" + duratuion);
        }
    }

    private void setVideoDetailInfo(BaseViewHolder helper, HomeBean.IssueListBean.ItemListBean item) {
        HomeBean.IssueListBean.ItemListBean.DataBean data = item.getData();
        // 标题
        helper.setText(R.id.tv_title, data.getTitle());
        // 简介
        helper.setText(R.id.expandable_text, data.getDescription());
        // 标签
        String duratuion = TimeUtils.durationFormat(data.getDuration());
        helper.setText(R.id.tv_tag, "#" + data.getCategory() + "/" + duratuion);
        //喜欢ni
        helper.setText(R.id.tv_action_favorites, data.getConsumption().getCollectionCount() + "");
        //分享
        helper.setText(R.id.tv_action_share, data.getConsumption().getShareCount() + "");
        //评论
        helper.setText(R.id.tv_action_reply, data.getConsumption().getReplyCount() + "");
        if (data.getAuthor() != null) {
            HomeBean.IssueListBean.ItemListBean.DataBean.AuthorBean author = data.getAuthor();
            helper.setText(R.id.tv_author_name, author.getName());
            helper.setText(R.id.tv_author_desc, author.getDescription());
            GlideApp.with(mContext)
                    .load(author.getIcon())
                    .placeholder(R.drawable.default_avatar)
                    .into((ImageView) helper.getView(R.id.iv_avatar));
        } else {
            helper.setVisible(R.id.layout_author_view, false);
        }
    }

}
