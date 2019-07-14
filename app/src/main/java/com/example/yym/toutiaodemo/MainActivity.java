package com.example.yym.toutiaodemo;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater layoutInflater;
    private FragmentTabHost tabHost;
    private Context context;
    private Class fragmentArray[] = {MainFragment.class,MeFragment.class};
    private String textViewArray[] = {"首页","我的"};
    private int[] selectorImg = new int[]{R.drawable.tab_home_selector, R.drawable.tab_me_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        layoutInflater=LayoutInflater.from(context);
        tabHost = findViewById(R.id.tabhost);
        tabHost.setup(context,getSupportFragmentManager(),R.id.contentLayout);
        for(int i = 0;i<fragmentArray.length;i++)
        {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(textViewArray[i]).setIndicator(getTabItemView(i));
            tabHost.addTab(tabSpec,fragmentArray[i],null);
        }

    }
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.tab_view,null);
        TextView textView = view.findViewById(R.id.tab_text);
        textView.setText(textViewArray[index]);
        ImageView imageView = view.findViewById(R.id.tab_image);
        imageView.setImageResource(selectorImg[index]);
        return view;
    }

}
