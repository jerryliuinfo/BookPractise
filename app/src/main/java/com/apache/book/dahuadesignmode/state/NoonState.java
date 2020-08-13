package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class NoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.hour < 13){
            System.out.println(String.format("当前时间 %s 饿了 午休",work.getHour()));
        }else {
            work.setState(new AfternoonState());
            work.writeProgram();

        }
    }
}
