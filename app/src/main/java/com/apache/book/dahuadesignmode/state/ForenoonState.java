package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class ForenoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.hour < 12){
            System.out.println(String.format("当前时间 %s 上午工作精神百倍", work.getHour()));
        }else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
