package com.example.test.myapplication.activity;

import android.app.Application;

import com.example.test.myapplication.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/6/16.
 */
public class BaseApp extends Application {

    public static BaseApp baseApp;

    public static BaseApp getInstance() {
        return baseApp;
    }

    @Override
    public void onCreate() {
        baseApp = this;
        super.onCreate();
        //初始化图片下载器
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }

    public String getUrl() {
        return getString(R.string.base_url);
    }
}
