package com.apache.book.framewok.aroute.facade.service;

import com.apache.book.framewok.aroute.facade.template.IProvider;

import java.lang.reflect.Type;

/**
 * Created by Jerry on 2019/2/6.
 */
public interface SerializationService extends IProvider {

    String object2Json(Object instance);

    <T> T parseObject(String input, Type type);
}
