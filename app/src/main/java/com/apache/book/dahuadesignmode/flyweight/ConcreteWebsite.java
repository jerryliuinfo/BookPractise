package com.apache.book.dahuadesignmode.flyweight;

import com.apache.book.dahuadesignmode.bean.User;

/**
 * Created by 01370340 on 2017/8/31.
 */

public class ConcreteWebsite implements IWebsite {
    private String name;
    public ConcreteWebsite(String name) {
        this.name = name;
    }

    @Override
    public void use(User user) {
        System.out.println("网站分类："+name +", 用户: "+user.name);
    }
}
