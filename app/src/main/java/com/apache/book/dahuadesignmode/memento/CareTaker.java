package com.apache.book.dahuadesignmode.memento;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class CareTaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
