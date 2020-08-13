package com.apache.book.dahuadesignmode.proxy.dynamic;

import com.apache.book.dahuadesignmode.proxy.AbstractTicket;
import com.apache.book.dahuadesignmode.proxy.stati.People;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 01370340 on 2018/3/16.
 */

public class TellerProxy implements InvocationHandler {

    private AbstractTicket target;

    public TellerProxy(AbstractTicket abstractTicket) {
        this.target = abstractTicket;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy==" + proxy.getClass());
        System.out.println("invoke proxy= " +proxy +", method name =" + method.getName());

        if (args != null){
            int length = args.length;
            if (length > 0){
                for (int i = 0; i < length; i++) {
                    if (args.length > 1){
                        System.out.println(String.format("args[ %s } = %s", i, args[i]));
                    }
                }
            }
        }


        System.out.println("【请刷卡】");
        if (((People)target).getBalance() < 10){
            return "卡上余额不足10元，请放行";
        }

        return method.invoke(target,args);
    }


    public Object getProxyInstance(){

        System.out.println("this classLoader = "+ getClass().getClassLoader());
        System.out.println("target classLoader = "+target.getClass().getClassLoader());

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
}
