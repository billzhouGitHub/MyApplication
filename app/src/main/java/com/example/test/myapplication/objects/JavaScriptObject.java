package com.example.test.myapplication.objects;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.test.myapplication.zxing.android.CaptureActivity;

/**
 * Created by Administrator on 2016/6/24.
 */
public class JavaScriptObject {
    Activity mContxt;

    public JavaScriptObject(Activity mContxt) {
        this.mContxt = mContxt;
    }

    @JavascriptInterface
    public void fun1FromAndroid(String name) {
        Intent intent = new Intent(mContxt, CaptureActivity.class);
        mContxt.startActivityForResult(intent, 1);
    }

    public void fun2(String name) {
        Toast.makeText(mContxt, "调用fun2:" + name, Toast.LENGTH_SHORT).show();

    }


}
