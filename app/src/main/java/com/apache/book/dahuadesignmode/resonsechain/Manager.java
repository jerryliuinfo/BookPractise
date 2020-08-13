package com.apache.book.dahuadesignmode.resonsechain;

/**
 * 管理者
 * Created by lenovo on 2016/11/13.
 */

public abstract class Manager {
    public String name;

    public Manager(String name) {
        this.name = name;
    }

    protected Manager superior; //管理者的上级类
    public void setSuperior(Manager superior){
        this.superior = superior;
    }

    public abstract void dealRequest(Request request);
}
