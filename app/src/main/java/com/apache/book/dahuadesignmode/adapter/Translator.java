package com.apache.book.dahuadesignmode.adapter;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class Translator extends Player {
    private ForeignFastwards foreignFastwards = new ForeignFastwards();
    public Translator(String player) {
        super(player);
        foreignFastwards.name = player;
    }

    @Override
    public void attack() {
        foreignFastwards.attack();
    }

    @Override
    public void defense() {
        foreignFastwards.defense();
    }
}
