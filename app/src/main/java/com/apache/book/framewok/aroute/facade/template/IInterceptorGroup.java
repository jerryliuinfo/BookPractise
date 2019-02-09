package com.apache.book.framewok.aroute.facade.template;

import java.util.Map;

/**
 * Created by Jerry on 2019/2/7.
 */
public interface IInterceptorGroup  {

    void loadInto(Map<Integer, Class<? extends IInterceptor>> interceptor);
}
