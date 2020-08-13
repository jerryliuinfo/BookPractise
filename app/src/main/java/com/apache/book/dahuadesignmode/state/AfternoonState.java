package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class AfternoonState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.hour < 17){
            System.out.println(String.format("当前时间 %s, 下午状态还不错，继续努力", work.getHour()));
        }else {
            work.setState(new EveningState());
            work.writeProgram();

        }
    }
}
