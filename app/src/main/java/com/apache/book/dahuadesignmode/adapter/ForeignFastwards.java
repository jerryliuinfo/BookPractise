package com.apache.book.dahuadesignmode.adapter;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class ForeignFastwards  {
    public String name;

    public ForeignFastwards() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack() {
        System.out.println("ForeignFastwards  attack"+ name);
    }

    public void defense() {
        System.out.println("ForeignFastwards  defense"+ name);
    }
}
