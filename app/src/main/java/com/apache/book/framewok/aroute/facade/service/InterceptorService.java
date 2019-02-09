package com.apache.book.framewok.aroute.facade.service;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.facade.callback.InterceptorCallback;
import com.apache.book.framewok.aroute.facade.template.IProvider;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface InterceptorService extends IProvider {

    void doInterceptions(Postcard postcard, InterceptorCallback callback);
}
