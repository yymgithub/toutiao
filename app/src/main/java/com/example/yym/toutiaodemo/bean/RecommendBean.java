package com.example.yym.toutiaodemo.bean;

import java.util.List;

public class RecommendBean {
    private String title;
    private String article_url;
    private String comment_count;
    private List<ImageList> image_list;
    private String source;
    private String behot_time;
    private String label;

    private MiddleImage middle_image;

    public static final int TEXT_TYPE = 1;
    public static final int THREE_IMAGE_TYPE = 2;
    public static final int MIDDLE_IMAGE_TYPE = 3;
    //添加类型变量
    public int type;

    public List<ImageList> getImage_list() {
        return image_list;
    }

    public MiddleImage getMiddle_image() {
        return middle_image;
    }

    public String getLabel() {
        return label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle_url() {
        return article_url;
    }

    public String getComment_count() {
        return comment_count;
    }


    public String getSource() {
        return source;
    }

    public String getBehot_time() {
        return behot_time;
    }
}


