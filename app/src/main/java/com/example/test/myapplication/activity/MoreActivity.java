package com.example.test.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.test.myapplication.R;
import com.github.ksoichiro.android.observablescrollview.TouchInterceptionFrameLayout;

/**
 * Created by Administrator on 2016/6/17.
 */
public class MoreActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


    }

    public void jumpAboutus(View view) {
        startActivity(new Intent(this, AboutUSActivity.class));
    }

}
