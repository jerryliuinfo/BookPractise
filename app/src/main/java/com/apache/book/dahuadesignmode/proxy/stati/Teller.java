package com.apache.book.dahuadesignmode.proxy.stati;

import com.apache.book.dahuadesignmode.proxy.AbstractTicket;

/**
 * Created by 01370340 on 2018/3/16.
 *
 * 相当于代理类
 */


public class Teller implements AbstractTicket {
    private People people;

    public Teller(People people) {
        this.people = people;
    }

    @Override
    public void checkTicket(String card,int balance) {
        people.checkTicket(card,balance);
        if (people.getBalance() < 10){
            System.out.println("卡上余额不足10元, 请充满，限行");
        }
        System.out.println("开闸，放行");

    }
}
