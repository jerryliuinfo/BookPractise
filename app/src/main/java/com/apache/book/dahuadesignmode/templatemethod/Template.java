package com.apache.book.dahuadesignmode.templatemethod;

/**
 * Created by lenovo on 2016/11/6.
 */

public abstract class Template {
    public void run(){
        step1();
        step2();
        step3();
    }

    private void step1() {
        System.out.println("step1...");
    }
    public abstract void step2();
    public abstract void step3();
}
