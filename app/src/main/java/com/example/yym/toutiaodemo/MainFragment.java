package com.example.yym.toutiaodemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private TabLayout colorTrackTabLayout;
    private ViewPager mainViewPager;
    private List<Fragment> mainFragments;
    private List<String> titles;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main, container,false);
        colorTrackTabLayout = view.findViewById(R.id.color_tab);
        mainViewPager = view.findViewById(R.id.main_viewPager);
        initFragment();
        initTab();
        mainViewPager.setAdapter(new MyPagerAdapter(getChildFragmentManager(), mainFragments, titles));
        //关联layout和viewPager
        //隐藏指示器
        //设置每个Tab的内边距
        colorTrackTabLayout.setSelectedTabIndicatorHeight(0);
        colorTrackTabLayout.setupWithViewPager(mainViewPager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void initFragment() {
        mainFragments = new ArrayList<>();
        mainFragments.add(new RecommendFragment());
        mainFragments.add(new HotspotFragment());
    }

    private void initTab() {
        titles = new ArrayList<>();
        titles.add("推荐");
        titles.add("热点");
        colorTrackTabLayout.addTab(colorTrackTabLayout.newTab().setText(titles.get(0)));
        colorTrackTabLayout.addTab(colorTrackTabLayout.newTab().setText(titles.get(1)));
    }
}
