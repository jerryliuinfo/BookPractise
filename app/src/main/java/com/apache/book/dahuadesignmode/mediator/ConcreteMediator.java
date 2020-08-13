package com.apache.book.dahuadesignmode.mediator;

/**
 * Created by jerryliu on 2017/8/30.
 */

public class ConcreteMediator extends Mediator {
    private ConcreteColleage1 colleage1;
    private ConcreteColleage2 colleage2;

    public void setColleage1(ConcreteColleage1 colleage1) {
        this.colleage1 = colleage1;
    }

    public void setColleage2(ConcreteColleage2 colleage2) {
        this.colleage2 = colleage2;
    }

    @Override
    public void send(String message, Colleague colleague) {
        if (colleague instanceof ConcreteColleage1){
            colleage1.notify(message);
        }else if (colleague instanceof ConcreteColleage2){
            colleage2.notify(message);
        }
    }
}
