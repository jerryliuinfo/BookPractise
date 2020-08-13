package com.apache.book.dahuadesignmode.adapter;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class Forwards extends Player {
    public static final String TAG = Forwards.class.getSimpleName();
    public Forwards(String player) {
        super(player);
    }

    @Override
    public void attack() {
        System.out.println("Forwards  attack"+ getPlayer());
    }

    @Override
    public void defense() {
        System.out.println("Forwards  defense"+ getPlayer());
    }
}
