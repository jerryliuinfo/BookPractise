package com.apache.book.dahuadesignmode.composite;

/**
 * Created by jerryliu on 2017/8/23.
 */

public abstract class Component {
    public String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component c);
    public abstract void remove(Component c);
    public abstract void display(int depth);
}
