package com.example.test.myapplication.utils;

import android.app.Activity;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * Created by Administrator on 2016/6/16.
 */
public class ProgresUtil {

    public static KProgressHUD getProgress(Activity activity) {
        KProgressHUD progressHUD = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f);
        return progressHUD;
    }


}
