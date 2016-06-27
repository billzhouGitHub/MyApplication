package com.example.test.myapplication.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/17.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setActivityTitle(String s) {
        TextView tv = (TextView) findViewById(R.id.title);
        tv.setText(s);
    }

    public Toolbar getLeftButton() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.iconfontfanhui);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return toolbar;
    }

    public ImageView getRightButton() {
        ImageView tv = (ImageView) findViewById(R.id.rightbutton);
        tv.setVisibility(View.VISIBLE);
        return tv;
    }

}
