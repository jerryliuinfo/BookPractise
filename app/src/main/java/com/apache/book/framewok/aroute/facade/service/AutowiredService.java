package com.apache.book.framewok.aroute.facade.service;

import com.apache.book.framewok.aroute.facade.template.IProvider;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface AutowiredService  extends IProvider {

    void autoWire(Object instance);
}
