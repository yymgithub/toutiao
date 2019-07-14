package com.example.yym.toutiaodemo;

import com.example.yym.toutiaodemo.bean.RecommendData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    //获取推荐新闻数据
    @GET("v88")
    Call<RecommendData> getRecommendData();


}
