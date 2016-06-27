package com.example.test.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/16.
 */
public class SplashActivity extends FragmentActivity {

    private static int JUMPWAITERTIME = 2000;
    // 定义消息处理类，用来处理Activity跳转
    private Handler handler = new Handler();
    // 起用线程处理Activity跳转
    private Runnable runnable = new Runnable() {
        public void run() {
            // 停止线程在次执行
            handler.removeCallbacks(runnable);
            // 执行Activity跳转，转到登录Activity
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            // 结束当前的Activity，不进行堆栈
            SplashActivity.this.finish();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splashlayout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, JUMPWAITERTIME);
    }
}
