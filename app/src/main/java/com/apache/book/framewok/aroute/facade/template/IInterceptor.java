package com.apache.book.framewok.aroute.facade.template;

import com.apache.book.framewok.aroute.bean.Postcard;
import com.apache.book.framewok.aroute.facade.callback.InterceptorCallback;

/**
 * Created by Jerry on 2019/2/7.
 */
public interface IInterceptor extends IProvider {

    void process(Postcard postcard, InterceptorCallback callback);
}
