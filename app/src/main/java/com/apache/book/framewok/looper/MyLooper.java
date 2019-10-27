package com.apache.book.framewok.looper;

import android.os.Looper;

/**
 * Created by Jerry on 2019-10-18.
 */
public class MyLooper {
    private static ThreadLocal<MyLooper> sThreadLocal = new ThreadLocal<>();

    private MyMessageQueue mQueue;

    private Thread mThread;

    private MyLooper(){
        mQueue = new MyMessageQueue();
        mThread = Thread.currentThread();
    }


    public static void prepare(){
        Looper looper;
        if (sThreadLocal.get() != null){
            throw new RuntimeException("only one Looper may be set for per thread");
        }

        sThreadLocal.set(new MyLooper());
    }

    public static MyLooper myLooper(){
        return sThreadLocal.get();
    }

     public static void loop(){
        MyLooper me = myLooper();
        if (me == null){
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MyMessageQueue queue = me.mQueue;

     }
}
