package com.apache.book.bean;

import android.graphics.Point;

import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/12/3.
 */
public class ObjectAnimatorBean {
    public void setPosition(Point point) {
        NLog.d("setPosition point = %s", point);
    }
}
