package com.example.test.myapplication.service;

import com.example.test.myapplication.R;
import com.example.test.myapplication.activity.BaseApp;
import com.example.test.myapplication.objects.BasicCallBack;
import com.loopj.android.http.JsonHttpResponseHandler;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/16.
 */
public class LoginService extends HttpService {

    public static void dologin(String name, String pwd, JsonHttpResponseHandler httpCallback) {
        Map<String, Object> data = new HashMap<>();
        data.put("un", name);
        data.put("ps", pwd);
        execute(BaseApp.getInstance().getString(R.string.user_login_url), data, httpCallback);
    }
}
