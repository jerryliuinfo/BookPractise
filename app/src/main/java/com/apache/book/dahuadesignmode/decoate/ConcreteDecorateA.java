package com.apache.book.dahuadesignmode.decoate;

/**
 * Created by jerryliu on 2017/7/16.
 */

public class ConcreteDecorateA extends Decorator {
    @Override
    public void operation() {
        super.operation();
        System.out.println("具体装饰对象A的操作");
    }
}
