package com.apache.book.dahuadesignmode.adapter;

/**
 * Created by jerryliu on 2017/8/14.
 */

public class Center extends Player {
    public static final String TAG = Center.class.getSimpleName();
    public Center(String player) {
        super(player);
    }

    @Override
    public void attack() {
        System.out.println("Center  attack"+ getPlayer());
    }

    @Override
    public void defense() {
        System.out.println("Center  defense"+ getPlayer());
    }


}
