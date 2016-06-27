package com.example.test.myapplication.activity;

import android.os.Bundle;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/23.
 */
public class AboutUSActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        setActivityTitle(getString(R.string.about_us));
        getLeftButton();
    }
}
