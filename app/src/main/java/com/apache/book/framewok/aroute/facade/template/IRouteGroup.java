package com.apache.book.framewok.aroute.facade.template;

import com.apache.book.bean.RouteMeta;

import java.util.Map;

/**
 * Group element.
 * Created by Jerry on 2019/2/7.
 */
public interface IRouteGroup {

    void loadInto(Map<String,RouteMeta> atlas);
}
