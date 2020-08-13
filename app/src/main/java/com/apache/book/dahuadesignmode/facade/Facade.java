package com.apache.book.dahuadesignmode.facade;

/**
 * Created by lenovo on 2016/12/1.
 */

public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    public Facade(){
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }
    public void methodA(){
        System.out.println("方法组A");
        one.methodOne();
        two.methodTwo();
        three.methodThree();
    }

    public void methodB(){
        System.out.println("方法组B");
        one.methodOne();
        three.methodThree();
    }
}
