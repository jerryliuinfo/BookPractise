package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class EveningState implements State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinished){
            work.setState(new RestState());
            work.getCurrent().writeProgram(work);
        }else {
            if (work.hour < 20){
                System.out.println(String.format("当前时间 %s 加班哦，疲惫至极",work.getHour()));
            }else {
                work.setState(new ForceWorkOffState());
                work.writeProgram();
            }
        }
    }
}
