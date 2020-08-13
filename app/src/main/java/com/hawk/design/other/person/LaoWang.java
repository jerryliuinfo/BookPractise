package com.hawk.design.other.person;

/**
 * Created by 01370340 on 2017/9/25.
 */

public class LaoWang extends Person {
    @Override
    public void beforeTranslate() {
        System.out.println("老王出发");
    }
}
