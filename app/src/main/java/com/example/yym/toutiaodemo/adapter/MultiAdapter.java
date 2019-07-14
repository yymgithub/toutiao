package com.example.yym.toutiaodemo.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.yym.toutiaodemo.R;
import com.example.yym.toutiaodemo.bean.RecommendBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URL;
import java.util.List;

public class MultiAdapter extends BaseQuickAdapter<RecommendBean, BaseViewHolder> {


    public MultiAdapter(@Nullable List<RecommendBean> data) {
        super(data);
        setMultiTypeDelegate(new MultiTypeDelegate<RecommendBean>() {
            @Override
            protected int getItemType(RecommendBean entity) {
                //根据你的实体类来判断布局类型
                if (entity.getLabel() != null) {
                    entity.type = RecommendBean.TEXT_TYPE;
                } else if (entity.getImage_list() != null) {
                    entity.type = RecommendBean.THREE_IMAGE_TYPE;
                } else {
                    entity.type = RecommendBean.MIDDLE_IMAGE_TYPE;
                }
                return entity.type;
            }
        });

        getMultiTypeDelegate()
                .registerItemType(RecommendBean.TEXT_TYPE, R.layout.item_text_news)
                .registerItemType(RecommendBean.MIDDLE_IMAGE_TYPE, R.layout.item_middle_image_news)
                .registerItemType(RecommendBean.THREE_IMAGE_TYPE, R.layout.item_three_image_news);
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendBean item) {
        helper.setText(R.id.news_title, item.getTitle())
                .setText(R.id.news_source, item.getSource())
                .setText(R.id.news_comment_count, item.getComment_count())
                .setText(R.id.news_time, item.getBehot_time());
        switch (helper.getItemViewType()) {
            case RecommendBean.TEXT_TYPE:


                break;
            case RecommendBean.MIDDLE_IMAGE_TYPE:
                Uri uri = Uri.parse(item.getMiddle_image().getUrl());
                SimpleDraweeView simpleDraweeView = helper.itemView.findViewById(R.id.news_middle_img);
                TextView textView = helper.itemView.findViewById(R.id.news_top);
                textView.setVisibility(View.GONE);
                simpleDraweeView.setImageURI(uri);
                break;
            case RecommendBean.THREE_IMAGE_TYPE:
                Uri uri_one = Uri.parse(item.getImage_list().get(0).getUrl());
                Uri uri_two = Uri.parse(item.getImage_list().get(1).getUrl());
                Uri uri_three = Uri.parse(item.getImage_list().get(2).getUrl());
                SimpleDraweeView simpleDraweeView1=helper.itemView.findViewById(R.id.news_three_img_one);
                SimpleDraweeView simpleDraweeView2=helper.itemView.findViewById(R.id.news_three_img_two);
                SimpleDraweeView simpleDraweeView3=helper.itemView.findViewById(R.id.news_three_img_third);
                TextView textView3 = helper.itemView.findViewById(R.id.news_top);
                textView3.setVisibility(View.GONE);
                simpleDraweeView1.setImageURI(uri_one);
                simpleDraweeView2.setImageURI(uri_two);
                simpleDraweeView3.setImageURI(uri_three);
                break;
        }

    }


}
