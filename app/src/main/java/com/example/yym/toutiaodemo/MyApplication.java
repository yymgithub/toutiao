package com.example.yym.toutiaodemo;

import android.app.Application;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        FLog.setMinimumLoggingLevel(FLog.VERBOSE);
    }

}
