package com.apache.book.dahuadesignmode.command;

/**
 * Created by jerryliu on 2017/8/29.
 */

public class ReceiverBeijingBarbecure implements IOperation {
    @Override
    public void bakeMutton() {
        System.out.println("北京烤羊肉");
    }

    @Override
    public void bakeChickenWing() {
        System.out.println("北京烤鸡翅");

    }
}
