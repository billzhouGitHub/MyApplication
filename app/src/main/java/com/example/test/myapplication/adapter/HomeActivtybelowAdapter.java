package com.example.test.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.myapplication.R;
import com.example.test.myapplication.objects.HomeNotification;

import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public class HomeActivtybelowAdapter extends AbBaseAdapter<HomeNotification> {

    private int layoutId;

    public HomeActivtybelowAdapter(Context context) {
        super(context);
    }

    public HomeActivtybelowAdapter(Context context, List<HomeNotification> list) {
        super(context, list);
    }

    public void setLayout(int l) {
        layoutId = l;
    }

    @Override
    protected void onInitView(View view, int i) {
        HomeNotification item = getItem(i);
        TextView message = get(view, R.id.message);
        TextView time = get(view, R.id.time);
        ImageView imageView = get(view, R.id.icon);
        message.setText(item.getMessage());
        time.setText(item.getTime());
    }

    @Override
    public int getContentView() {
        return layoutId;
    }
}
