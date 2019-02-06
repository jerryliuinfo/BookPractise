package com.apache.book.framewok.aroute.facade;

import com.apache.book.framewok.aroute.bean.Postcard;

/**
 * Created by Jerry on 2019/2/6.
 * 调用方可以使用这个callback来选择实现{@link NavigationCallback 中的一个或多个方法}
 */
public abstract class NavCallback implements NavigationCallback {
    @Override
    public void onFound(Postcard postcard) {

    }

    @Override
    public void onLost(Postcard postcard) {

    }

    @Override
    public abstract void onArrival(Postcard postcard);

    @Override
    public void onInterupt(Postcard postcard) {

    }
}
