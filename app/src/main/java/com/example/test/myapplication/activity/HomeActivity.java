package com.example.test.myapplication.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.HomeFragumentViewPageAdapter;
import com.example.test.myapplication.fragument.Home_fragument;
import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.TouchInterceptionFrameLayout;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout drawerLayout;
    private ViewPager v;
    private TabLayout tablyout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);


        InitView();
        InitData();
        InitControl();


    }

    private void InitControl() {
        tablyout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                v.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
        v.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tablyout.setScrollPosition(position, 0, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void InitData() {
        mToolbar.setTitle("Toolbar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        toggle.syncState();
        drawerLayout.setDrawerListener(toggle);

        ArrayList<String> data = new ArrayList<>();
        data.add("热门推荐");
        data.add("热门收藏");
        data.add("热门话题");
        data.add("本月热榜");
        for (String s : data) {
            Tab tab = tablyout.newTab();
            tab.setText(s);
            tablyout.addTab(tab);
        }
        InitFragument();
    }

    private void InitFragument() {
        Home_fragument home_fragument = new Home_fragument();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(home_fragument);
        fragmentList.add(new Home_fragument());
        fragmentList.add(new Home_fragument());
        fragmentList.add(new Home_fragument());
        HomeFragumentViewPageAdapter hadpter = new HomeFragumentViewPageAdapter(getSupportFragmentManager(), fragmentList);
        v.setAdapter(hadpter);

    }

    private void InitView() {
        mToolbar = (Toolbar) findViewById(R.id.mytoolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawerlayout);
        v = (ViewPager) findViewById(R.id.myviewpage);
        tablyout = (TabLayout) findViewById(R.id.mytablyout);
        TouchInterceptionFrameLayout layout = (TouchInterceptionFrameLayout) findViewById(R.id.container);
        layout.setScrollInterceptionListener(new TouchInterceptionFrameLayout.TouchInterceptionListener() {
            @Override
            public boolean shouldInterceptTouchEvent(MotionEvent motionEvent, boolean b, float v, float v1) {
                return true;
            }

            @Override
            public void onDownMotionEvent(MotionEvent motionEvent) {

            }

            @Override
            public void onMoveMotionEvent(MotionEvent motionEvent, float v, float v1) {

            }

            @Override
            public void onUpOrCancelMotionEvent(MotionEvent motionEvent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.getItem(0).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Toast.makeText(HomeActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return true;
    }

}




