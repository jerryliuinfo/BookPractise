package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class SleepingState implements State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间 %s 不行了睡着了", work.getHour()));
    }
}
