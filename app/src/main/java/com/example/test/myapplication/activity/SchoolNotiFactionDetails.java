package com.example.test.myapplication.activity;

import android.os.Bundle;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/20.
 */
public class SchoolNotiFactionDetails extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitynotifactiondetails);
        setActivityTitle("学校公告");
        getLeftButton();
    }
}
