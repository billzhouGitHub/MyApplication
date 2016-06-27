package com.example.test.myapplication.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 */
public abstract class AbBaseAdapter<T> extends android.widget.BaseAdapter {

    private List<T> list;
    private Context context;
    private View contentView;

    public AbBaseAdapter(Context context) {
        init(context, new ArrayList<T>());
    }


    public AbBaseAdapter(Context context, List<T> list) {
        init(context, list);
    }

    protected void init(Context context, List<T> ts) {
        this.list = ts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public T getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = inflate(getContentView());
        }
        onInitView(view, i);

        return view;
    }

    protected abstract void onInitView(View view, int i);

    protected View inflate(int layoutResID) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layoutResID, null);
        return view;
    }

    public abstract int getContentView();

    /**
     * @param view converView
     * @param id   控件的id
     * @return 返回<T extends View>
     */
    @SuppressWarnings("unchecked")
    protected <E extends View> E get(View view, int id) {
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        if (null == viewHolder) {
            viewHolder = new SparseArray<View>();
            view.setTag(viewHolder);
        }
        View childView = viewHolder.get(id);
        if (null == childView) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);

        }
        return (E) childView;
    }


}
