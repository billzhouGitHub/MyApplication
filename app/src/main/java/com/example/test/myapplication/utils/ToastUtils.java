package com.example.test.myapplication.utils;

/**
 * Created by Administrator on 2016/6/17.
 */

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast toast = null; //ToastµÄ¶ÔÏó£¡

    public static void showToast(Context mContext, String id) {
        if (toast == null) {
            toast = Toast.makeText(mContext, id, Toast.LENGTH_SHORT);
        } else {
            toast.setText(id);
        }
        toast.show();
    }
}