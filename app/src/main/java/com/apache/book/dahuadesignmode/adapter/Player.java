package com.apache.book.dahuadesignmode.adapter;

/**
 * Created by jerryliu on 2017/8/14.
 */

public abstract class Player {
    public String player;

    public Player(String player) {
        this.player = player;
    }

    public abstract void attack();

    public abstract void defense();


    public String getPlayer() {
        return player;
    }
}
