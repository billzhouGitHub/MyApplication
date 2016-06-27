package com.example.test.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.HomeActivtybelowAdapter;
import com.example.test.myapplication.objects.HomeNotification;
import com.example.test.myapplication.view.SlideShowView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class NewHomeActivity extends BaseActivity {

    private SlideShowView slideshowview;
    private ListView mylist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newhome);
        setActivityTitle(getString(R.string.home));
        InitView();
        InitData();
        InitControl();
    }

    private void InitControl() {
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(NewHomeActivity.this, SchoolNotiFacationActivity.class));
            }
        });
    }

    private void InitData() {

        List<HomeNotification> list = new ArrayList<>();
        list.add(new HomeNotification("测试通知内容..", "2016年6月20日 10:46:19", ""));

        HomeActivtybelowAdapter activtybelowAdapter = new HomeActivtybelowAdapter(this, list);
        activtybelowAdapter.setLayout(R.layout.home_item);
        mylist.setAdapter(activtybelowAdapter);
    }

    public void InitView() {
        slideshowview = (SlideShowView) findViewById(R.id.Myslideshowview);
        mylist = (ListView) findViewById(R.id.listView);
    }
}
