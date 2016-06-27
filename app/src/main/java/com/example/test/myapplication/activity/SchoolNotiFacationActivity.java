package com.example.test.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.HomeActivtybelowAdapter;
import com.example.test.myapplication.objects.HomeNotification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public class SchoolNotiFacationActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityschool);
        getLeftButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        getRightButton().setImageResource(R.drawable.iconfontcmstubiaozitihua05);
        setActivityTitle("学校公告");
        ListView mylist = (ListView) findViewById(R.id.listView);
        List<HomeNotification> list = new ArrayList<>();
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));
        list.add(new HomeNotification("通知:2016元旦放假通知", "2016年6月20日", ""));


        HomeActivtybelowAdapter activtybelowAdapter = new HomeActivtybelowAdapter(this, list);
        activtybelowAdapter.setLayout(R.layout.home_item_head);
        mylist.setAdapter(activtybelowAdapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(SchoolNotiFacationActivity.this, SchoolNotiFactionDetails.class));
            }
        });
    }
}
