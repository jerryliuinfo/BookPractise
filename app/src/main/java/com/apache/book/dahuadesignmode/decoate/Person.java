package com.apache.book.dahuadesignmode.decoate;

/**
 * Created by lenovo on 2016/10/31.
 */

public class Person implements IDecorate {
    public String name;
    public Person(){

    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的"+ name);
    }
}
