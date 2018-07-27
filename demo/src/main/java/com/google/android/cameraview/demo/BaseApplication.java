package com.google.android.cameraview.demo;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Author: lxy
 * Date: 2018/7/27
 * Version:1.0.0
 * Desc:
 */
public class BaseApplication extends Application {
    private static BaseApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        initNecessary();
    }

    private void initNecessary() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static Application getInstance() {
        return sApplication;
    }
}
