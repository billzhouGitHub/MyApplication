package com.example.test.myapplication.fragument;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.myapplication.R;
import com.example.test.myapplication.adapter.RecyclerItemAdpter;
import com.gc.materialdesign.views.ButtonFloat;

/**
 * Created by Administrator on 2016/6/16.
 */
public class Home_fragument extends Fragment {

    private View view;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragument_layout, container, false);
        ButtonFloat floatbtn = (ButtonFloat) findViewById(R.id.buttonFloat);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.scrollToPosition(0);
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) findViewById(R.id.recyview);
        //设置布局管理
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //设置item的添加删除动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //添加分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
        //设置适配器
        recyclerView.setAdapter(new RecyclerItemAdpter(getActivity()));
        return view;
    }

    private View findViewById(int layoutid) {
        return view.findViewById(layoutid);
    }
}
