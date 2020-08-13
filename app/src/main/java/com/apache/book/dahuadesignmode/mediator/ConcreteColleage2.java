package com.apache.book.dahuadesignmode.mediator;

/**
 * Created by jerryliu on 2017/8/30.
 */

public class ConcreteColleage2 extends Colleague {
    public ConcreteColleage2(Mediator mediator) {
        super(mediator);
    }

    @Override
    public void send(String message) {
        getMediator().send(message,this);
    }

    @Override
    public void notify(String message) {
        System.out.println("同事2得到信息："+message);
    }
}
