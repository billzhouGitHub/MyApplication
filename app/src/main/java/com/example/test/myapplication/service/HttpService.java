package com.example.test.myapplication.service;

import com.example.test.myapplication.R;
import com.example.test.myapplication.activity.BaseApp;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import org.json.JSONArray;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/6/16.
 */
public class HttpService {

    public static void execute(String url, Map<String, Object> data, JsonHttpResponseHandler callback) {
        url = BaseApp.getInstance().getUrl() + "/mobile/" + url;

        RequestParams map = new RequestParams();

        for (String key : data.keySet()) {
            map.put(key, data.get(key));
        }

        map.put("root", "0");
        map.put("pushToken", "");
        map.put("info", "Android 4.4.4|Xiaomi HM 1S");
        map.put("os", "Android");
        map.put("mac", "864376025563098");
        map.put("ver", BaseApp.getInstance().getString(R.string.version));
        map.put("rol", BaseApp.getInstance().getString(R.string.roal));
        map.put("ck", BaseApp.getInstance().getString(R.string.appname));
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(BaseApp.getInstance(), url, map, callback);
    }
}
