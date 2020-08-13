package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class RestState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间 %s 下班回家了", work.getHour()));
    }
}
