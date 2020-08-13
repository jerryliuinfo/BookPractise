package com.apache.book.dahuadesignmode.templatemethod;

/**
 * Created by lenovo on 2016/11/6.
 */

public class ConcreteClassB extends Template {
    @Override
    public void step2() {
        System.out.println("ConcreteClassB step2");
    }

    @Override
    public void step3() {
        System.out.println("ConcreteClassB step3");
    }
}
