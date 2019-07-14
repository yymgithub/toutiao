package com.example.yym.toutiaodemo;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

public class HotspotFragment extends Fragment {
    private SimpleDraweeView simpleDraweeView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_hotspot, container, false);
        simpleDraweeView = view.findViewById(R.id.news_img_test);
        Uri uri = Uri.parse("http://p9-tt.byteimg.com/list/300x196/tos-cn-i-0000/be61be46a5d611e992757cd30a545d72.webp");
        simpleDraweeView.setImageURI(uri);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
