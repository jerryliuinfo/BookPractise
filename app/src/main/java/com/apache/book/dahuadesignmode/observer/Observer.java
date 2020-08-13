package com.apache.book.dahuadesignmode.observer;

/**
 * @author Jerry
 * @Description:
 * @date 2016/12/4 14:20
 * @copyright TCL-MIG
 */

public abstract class Observer {
    protected String name;
    protected Notifier sub;

    public Observer(String name, Notifier sub) {
        this.name = name;
        this.sub = sub;
    }

    public abstract void update();
}
