package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class ForceWorkOffState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间 %s 强制下班",work.getHour()));
    }
}
