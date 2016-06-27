package com.example.test.myapplication.objects;

import com.example.test.myapplication.adapter.AbBaseAdapter;

/**
 * Created by Administrator on 2016/6/20.
 */
public class HomeNotification {

    private String Message;
    private String time;
    private String ico;

    public HomeNotification(String message, String time, String ico) {
        Message = message;
        this.time = time;
        this.ico = ico;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }
}
