package com.example.test.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.test.myapplication.R;
import com.example.test.myapplication.objects.BasicCallBack;
import com.example.test.myapplication.service.LoginService;
import com.example.test.myapplication.utils.ProgresUtil;
import com.example.test.myapplication.utils.StringUtils;
import com.example.test.myapplication.utils.ToastUtils;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/6/16.
 */
public class LoginActivity extends FragmentActivity {


    private EditText username;
    private EditText userpwd;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        InitView();
        InitControl();

    }

    private void InitControl() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = username.getText().toString();
//                String pwd = userpwd.getText().toString();
//                if (!CheckLogin(name, pwd))
//                    return;
//
//                final KProgressHUD progress = ProgresUtil.getProgress(LoginActivity.this);
//                progress.setLabel(getString(R.string.loging));
//                progress.show();
//                LoginService.dologin(name, pwd, new BasicCallBack() {
//                    @Override
//                    protected void onSuccess(List<Object> list) {
//                        super.onSuccess(list);
//                        progress.dismiss();
//                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    }
//                });
//                progress.dismiss();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));


            }
        });
    }

    public boolean CheckLogin(String name, String pwd) {
        if (StringUtils.isEmpty(name) | StringUtils.isEmpty(pwd)) {
            ToastUtils.showToast(this, getString(R.string.userinfoempty));
            return false;
        }
        return true;


    }

    private void InitView() {
        username = (EditText) findViewById(R.id.txt_name);
        userpwd = (EditText) findViewById(R.id.txt_pwd);
        btn = (Button) findViewById(R.id.submit);
    }
}
