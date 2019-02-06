package com.apache.book.framewok.aroute.facade;

import com.apache.book.framewok.aroute.bean.Postcard;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface InterceptorCallback {

    void onContinue(Postcard postcard);

    void onInterupted(Postcard postcard);
}
