package com.apache.book.dahuadesignmode.memento;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMenmento(){
        return new Memento(state);
    }

    public void setMenmento(Memento menmento){
        this.state = menmento.getState();
    }


    public void show(){
        System.out.println("state : "+ state);
    }
}
