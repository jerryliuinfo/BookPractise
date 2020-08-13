package com.apache.book.dahuadesignmode.proxy.stati;

import com.apache.book.dahuadesignmode.proxy.AbstractTicket;

/**
 * Created by 01370340 on 2018/3/16.
 * 相当于委托类
 */

public class People implements AbstractTicket {

    private int balance;

    public People(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public void checkTicket(String card,int balance) {
        System.out.println("滴，学生卡。卡上余额" + balance +"元");
    }
}
