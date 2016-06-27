package com.example.test.myapplication.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.test.myapplication.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/6/17.
 */
public class MainActivity extends TabActivity {

    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SlidingMenu menu = new SlidingMenu(this);
        // configure the SlidingMenu
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffset(150);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.activity_more);

        List<tabitem> list = new ArrayList<>();
        list.add(new tabitem(getString(R.string.home), getString(R.string.home_url), "home"));
        list.add(new tabitem(getString(R.string.repository), getString(R.string.repository_url), "ziyuan"));
        list.add(new tabitem(getString(R.string.work), getString(R.string.work_url), "work"));
        list.add(new tabitem(getString(R.string.my), getString(R.string.my_url), "my"));

        for (tabitem t : list) {
            createTab(t.getName(), t.getUrl(), t.getIconame());
        }

    }


    /**
     * 创建tab
     */
    private void createTab(String text, String url, String iconame) {

        Intent intent = new Intent();
        intent.setClassName(getApplicationContext(), url);
        View view = View.inflate(this, R.layout.tab_indicator, null);
        // tab显示内容设置
        TextView tv = (TextView) view.findViewById(R.id.lab_text);
        tv.setText(text);
        // tab图片设置
        ImageView iv = (ImageView) view.findViewById(R.id.icon_image);
        int icon = getResources().getIdentifier(iconame + "_selector", "drawable", getPackageName());
        iv.setImageResource(icon);

        TabHost.TabSpec spec = getTabHost().newTabSpec(text);
        spec.setIndicator(view);
        spec.setContent(intent);

        getTabHost().addTab(spec);
    }

    private class tabitem {
        private String name;
        private String url;
        private String iconame;

        public tabitem(String name, String url, String iconame) {
            this.name = name;
            this.url = url;
            this.iconame = iconame;
        }

        public String getIconame() {
            return iconame;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

    }
}
