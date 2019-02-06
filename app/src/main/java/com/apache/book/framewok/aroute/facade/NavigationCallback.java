package com.apache.book.framewok.aroute.facade;

import com.apache.book.framewok.aroute.bean.Postcard;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface NavigationCallback {

    void onFound(Postcard postcard);

    void onLost(Postcard postcard);

    void onArrival(Postcard postcard);

    void onInterupt(Postcard postcard);

}
