package com.apache.book.dahuadesignmode.memento;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class RoleState {
    private int vit = 80;
    private int atk = 80;
    private int def = 80;

    public RoleStateMemento createMemento(){
        return new RoleStateMemento(vit,atk,def);
    }

    public void recoveryRoleState(RoleStateMemento memento){
        this.vit = memento.vit;
        this.atk = memento.atk;
        this.def = memento.def;
    }

    public void fight(){
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }


    public void show(){
        System.out.println("vit = "+ vit +", atk = "+atk +", def = "+ def);
    }

}
