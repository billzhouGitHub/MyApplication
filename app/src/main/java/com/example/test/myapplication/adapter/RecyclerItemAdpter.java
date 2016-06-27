package com.example.test.myapplication.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.myapplication.activity.HomeActivity;
import com.example.test.myapplication.R;
import com.example.test.myapplication.ui.dialog.ShowPhotoFragment;
import com.example.test.myapplication.utils.ImageDownloadUtil;

/**
 * Created by Administrator on 2016/6/16.
 */
public class RecyclerItemAdpter extends RecyclerView.Adapter<RecyclerItemAdpter.MyViewHolder> {

    private Activity act;

    public RecyclerItemAdpter(Activity activity) {
        this.act = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                act).inflate(R.layout.item_layout, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ImageDownloadUtil.downloadImg("http://img1.gtimg.com/ent/pics/hv1/117/7/1955/127125777.jpg", holder.img);

//        holder.img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Drawable drawable = holder.img.getDrawable();
//                ShowPhotoFragment sf=new ShowPhotoFragment(drawable);
//                sf.show(((HomeActivity)act).getSupportFragmentManager(),"show");
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.item_img);
        }
    }
}
