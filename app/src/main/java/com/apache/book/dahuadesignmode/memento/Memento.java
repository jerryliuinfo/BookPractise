package com.apache.book.dahuadesignmode.memento;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }


    public String getState() {
        return state;
    }
}
