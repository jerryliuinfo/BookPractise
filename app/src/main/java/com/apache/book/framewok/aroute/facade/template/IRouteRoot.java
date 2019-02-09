package com.apache.book.framewok.aroute.facade.template;

import java.util.Map;

/**
 * Root element.
 * Created by Jerry on 2019/2/7.
 */
public interface IRouteRoot {

    void loadInto(Map<String,Class<? extends IRouteRoot>> routes);

}
