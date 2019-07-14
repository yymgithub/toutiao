package com.example.yym.toutiaodemo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.yym.toutiaodemo.adapter.MultiAdapter;
import com.example.yym.toutiaodemo.bean.DataContent;
import com.example.yym.toutiaodemo.bean.RecommendBean;
import com.example.yym.toutiaodemo.bean.RecommendData;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecommendFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    public static final String baseUrl = "https://is-hl.snssdk.com/api/news/feed/";
    private RetrofitService retrofitService;
    private RecyclerView recyclerView;
    private List<RecommendBean> recommends;
    private MultiAdapter multiAdapter;
    private SwipeRefreshLayout swipeLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_recommend, container, false);
        recyclerView = view.findViewById(R.id.recommend_recycler);
        swipeLayout = view.findViewById(R.id.recommend_recycler_refresh);
        swipeLayout.setColorSchemeColors(Color.GRAY);
        swipeLayout.setOnRefreshListener(this);
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        initRetrofit();
        getData();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //初始化retrofit
    private void initRetrofit() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    //
    private void getData() {
        Call<RecommendData> recommendDataCall = retrofitService.getRecommendData();
        recommendDataCall.enqueue(new Callback<RecommendData>() {
            @Override
            public void onResponse(Call<RecommendData> call, Response<RecommendData> response) {
                System.out.println("#############################");

                if (response.isSuccessful()) {

                    RecommendData recommendData = response.body();
                    List<DataContent> dataContents = recommendData.getData();
                    List<String> contents = new ArrayList<>();
                    for (int i = 0; i < dataContents.size(); i++) {
                        contents.add(dataContents.get(i).getContent());
                    }
                    //解析content
                    Gson gson = new Gson();
                    recommends = new ArrayList<>();
                    for (int i = 0; i < contents.size(); i++) {
                        RecommendBean recommendTmp = gson.fromJson(contents.get(i), RecommendBean.class);
                        recommends.add(recommendTmp);
                    }
                    multiAdapter = new MultiAdapter(recommends);
                    recyclerView.setAdapter(multiAdapter);
                    multiAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                            Toast.makeText(getContext(), "点击了第" + (position + 1) + "条条目", Toast.LENGTH_SHORT).show();
                            getActivity().startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(recommends.get(position).getArticle_url())));
                        }
                    });
                    System.out.print(recommendData);
                } else {
                    System.out.print("请求错误");
                }
            }

            @Override
            public void onFailure(Call<RecommendData> call, Throwable t) {
                System.out.print("请求错误");
                t.getStackTrace();
            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                swipeLayout.setRefreshing(false);
                getData();
            }
        }, 500);

    }
}
