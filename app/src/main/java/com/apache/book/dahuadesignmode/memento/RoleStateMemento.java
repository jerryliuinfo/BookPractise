package com.apache.book.dahuadesignmode.memento;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class RoleStateMemento {
    public int vit;
    public int atk;
    public int def;

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }
}
