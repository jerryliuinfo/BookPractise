package com.apache.book;

import android.app.Application;

import com.apache.book.util.log.Logger;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/11/22.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NLog.setDebug(true,Logger.DEBUG);
    }
}
