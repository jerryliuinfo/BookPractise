package com.apache.book.dahuadesignmode.state;

/**
 * Created by jerryliu on 2017/7/23.
 */

public class Work {

    public int hour;

    public boolean isFinished;

    public State current;

    public Work() {
        current = new ForenoonState();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public State getCurrent() {
        return current;
    }

    public void setState(State current) {
        this.current = current;
    }

    public void writeProgram(){
        if (current != null){
            current.writeProgram(this);
        }
    }
}
