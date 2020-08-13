package com.apache.book.dahuadesignmode.prototype;

/**
 * Created by lenovo on 2016/11/2.
 */

public class WorkExperience implements Cloneable{
    public String timeArea;
    public String company;

    public WorkExperience cloneObject(){
        try {
            return (WorkExperience) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
