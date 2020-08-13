package com.apache.book;

import android.app.Application;
import android.content.Context;

import com.apache.book.util.log.Logger;
import com.apache.book.util.log.NLog;

/**
 * Created by Jerry on 2018/11/22.
 */
public class MyApplication extends Application {



    private static Context context;
    private static MyApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        NLog.setDebug(true,Logger.DEBUG);
        context = this;
        application = this;
        com.apache.book.dahuadesignmode.util.NLog.setDebug(true, com.apache.book.dahuadesignmode.util.Logger.DEBUG);
    }

    public static Context getContext() {
        return context;
    }

    public static MyApplication getApplication() {
        return application;
    }
}
