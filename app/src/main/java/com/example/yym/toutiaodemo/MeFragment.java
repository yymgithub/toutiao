package com.example.yym.toutiaodemo;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MeFragment  extends Fragment implements View.OnClickListener {
    //头部内容
    private ImageView tou_img_bg;
    private CircleImageView no_in_img;
    private CircleImageView in_touxiang_img;
    private TextView user_vertify;
    private ImageView tou_right;

    //我的收藏、我的评论、我的点赞、我的历史
    private TextView collect_btn;
    private TextView comment_btn;
    private TextView favour_btn;
    private TextView history_btn;

    //我的关注、我的钱包、消息通知、小程序、扫一扫、免流量服务、广告推广、用户反馈、系统设计
    private RelativeLayout focus_layout;
    private RelativeLayout wallet_layout;
    private RelativeLayout message_layout;
    private RelativeLayout runtine_layout;
    private RelativeLayout scan_layout;
    private RelativeLayout free_flow_layout;
    private RelativeLayout advert_layout;
    private RelativeLayout user_feedback_layout;
    private RelativeLayout sys_settting_layout;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.me,container,false);
        activity=this.getActivity();
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.no_in_img:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                  System.out.print(e.getMessage());
                }
                break;
            case R.id.in_touxiang_img:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            case R.id.user_vertify:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            case R.id.tou_right:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            //我的收藏、我的评论、我的点赞、我的历史
            case R.id.collect_btn:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            case R.id.comment_btn:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            case R.id.favour_btn:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }
                break;
            case R.id.history_btn:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            //我的关注、我的钱包、消息通知、小程序、扫一扫、免流量服务、广告推广、用户反馈、系统设计
            case R.id.focus_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.wallet_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.message_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.runtine_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.scan_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.free_flow_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.advert_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.user_feedback_layout:
                try {
                    activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.toutiao.com")));
                }catch (ActivityNotFoundException e){
                    System.out.print(e.getMessage());
                }break;
            case R.id.sys_settting_layout:
                Toast.makeText(getActivity(), "系统设置", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    private void initView(View view){
        tou_img_bg= view.findViewById(R.id.iv_bg);
        no_in_img=view.findViewById(R.id.no_in_img);

        in_touxiang_img=view.findViewById(R.id.in_touxiang_img);
        in_touxiang_img.setOnClickListener(this);

        user_vertify= view.findViewById(R.id.user_vertify);
        user_vertify.setOnClickListener(this);

        tou_right=view.findViewById(R.id.tou_right);
        tou_right.setOnClickListener(this);
        //我的收藏、我的评论、我的点赞、我的历史
       collect_btn=view.findViewById(R.id.collect_btn);
       collect_btn.setOnClickListener(this);
       comment_btn=view.findViewById(R.id.comment_btn);
       comment_btn.setOnClickListener(this);

       favour_btn=view.findViewById(R.id.favour_btn);
       favour_btn.setOnClickListener(this);
       history_btn=view.findViewById(R.id.history_btn);
       history_btn.setOnClickListener(this);
        //我的关注、我的钱包、消息通知、小程序、扫一扫、免流量服务、广告推广、用户反馈、系统设计
        focus_layout=view.findViewById(R.id.focus_layout);
        focus_layout.setOnClickListener(this);
        wallet_layout=view.findViewById(R.id.wallet_layout);
        wallet_layout.setOnClickListener(this);
        message_layout=view.findViewById(R.id.message_layout);
        message_layout.setOnClickListener(this);
        runtine_layout=view.findViewById(R.id.runtine_layout);
        runtine_layout.setOnClickListener(this);
        scan_layout=view.findViewById(R.id.scan_layout);
        scan_layout.setOnClickListener(this);
        free_flow_layout= view.findViewById(R.id.free_flow_layout);
        free_flow_layout.setOnClickListener(this);
        advert_layout=view.findViewById(R.id.advert_layout);
        advert_layout.setOnClickListener(this);
        user_feedback_layout= view.findViewById(R.id.user_feedback_layout);
        user_feedback_layout.setOnClickListener(this);
        sys_settting_layout=view.findViewById(R.id.sys_settting_layout);
        sys_settting_layout.setOnClickListener(this);
        tou_img_bg.setOnClickListener(this);
        no_in_img.setOnClickListener(this);


    }
}
