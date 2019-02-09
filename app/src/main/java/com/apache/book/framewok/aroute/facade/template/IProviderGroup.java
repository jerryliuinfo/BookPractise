package com.apache.book.framewok.aroute.facade.template;

import java.util.Map;

/**
 * Created by Jerry on 2019/2/7.
 */
public interface IProviderGroup {

    void loadInto(Map<String, RouteMeta> providers);

}
