package com.example.test.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.AbBaseAdapter;
import com.example.test.myapplication.utils.CacheUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/17.
 */
public class WorkActivity extends BaseActivity {
    private static final int GETCONTENT = 1;
    List<String> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        setActivityTitle("我的工作");
        GridView gridView = (GridView) findViewById(R.id.gridView);

        list.add("班级通知");
        list.add("作业");
        list.add("课程表");
        list.add("相册");
        list.add("出去动态");
        list.add("视频");
        gridView.setAdapter(new item(this, list));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 3) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("image/*");
                    startActivityForResult(intent, GETCONTENT);
                }
            }
        });
    }

    private class item extends AbBaseAdapter<String> {

        public item(Context context, List<String> list) {
            super(context, list);
        }

        @Override
        protected void onInitView(View view, int i) {
            int id = 0;
            switch (i) {
                case 0:
                    id = R.drawable.iconfonttongzhi;
                    break;
                case 1:
                    id = R.drawable.iconfontzuoye;
                    break;
                case 2:
                    id = R.drawable.iconfontwodekecheng;
                    break;
                case 3:
                    id = R.drawable.iconfontchongfuzhaopian;
                    break;
                case 4:
                    id = R.drawable.iconfontdongtai;
                    break;
                case 5:
                    id = R.drawable.iconfonticon9;
                    break;

            }
            ImageView img = get(view, R.id.imageView2);
            img.setImageResource(id);
            TextView t = get(view, R.id.textView4);
            t.setText(getItem(i));
        }

        @Override
        public int getContentView() {
            return R.layout.workgriditem;
        }
    }

}
