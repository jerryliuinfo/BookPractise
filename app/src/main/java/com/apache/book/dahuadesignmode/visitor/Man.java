package com.apache.book.dahuadesignmode.visitor;

/**
 * Created by 01370340 on 2017/10/29.
 */

public class Man extends Person {
    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}
