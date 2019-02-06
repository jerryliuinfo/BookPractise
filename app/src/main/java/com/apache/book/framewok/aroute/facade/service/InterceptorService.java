package com.apache.book.framewok.aroute.facade.service;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.facade.InterceptorCallback;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface InterceptorService extends IProvider {

    void doInterceptions(Postcard postcard, InterceptorCallback callback);
}
