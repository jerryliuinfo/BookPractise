package com.apache.book.samples.animation;

/**
 * Created by Jerry on 2018/11/25.
 */
public class MyAnimationHandler {
    public final static ThreadLocal<MyAnimationHandler> sAnimationHandler = new ThreadLocal<>();


    public static MyAnimationHandler getInstance(){
        if (sAnimationHandler.get() != null){
             sAnimationHandler.set(new MyAnimationHandler());
        }
        return sAnimationHandler.get();
    }
}
