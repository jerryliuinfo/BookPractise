package com.apache.book.framewok.aroute.core;

import com.apache.book.bean.RouteMeta;
import com.apache.book.bean.UniqueKeyTreeMap;
import com.apache.book.framewok.aroute.facade.template.IInterceptor;
import com.apache.book.framewok.aroute.facade.template.IProvider;
import com.apache.book.framewok.aroute.facade.template.IRouteGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jerry on 2019/2/8.
 */
public class Warehouse {
    // Cache route and metas
    /**
     * key: groupName
     * value: Class<? extends IRouteGroup>
     */
    static Map<String, Class<? extends IRouteGroup>> groupsIndex = new HashMap<>();
    /**
     * key:path
     * value:RouteMeta
     */
    static Map<String, RouteMeta> routes = new HashMap<>();


    // Cache provider
    static Map<Class, IProvider> providers = new HashMap<>();
    static Map<String, RouteMeta> providersIndex = new HashMap<>();

    // Cache interceptor
    static Map<Integer, Class<? extends IInterceptor>> interceptorsIndex = new UniqueKeyTreeMap<>("More than one interceptors use same priority [%s]");
    static List<IInterceptor> interceptors = new ArrayList<>();

    static void clear() {
        routes.clear();
        groupsIndex.clear();
        providers.clear();
        providersIndex.clear();
        interceptors.clear();
        interceptorsIndex.clear();
    }
}
