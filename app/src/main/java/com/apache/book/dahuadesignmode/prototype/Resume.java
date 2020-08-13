package com.apache.book.dahuadesignmode.prototype;

/**
 * Created by lenovo on 2016/11/2.
 */

public class Resume implements Cloneable{
    public String name;
    public String age;
    public String sex;
    public WorkExperience work;

    public Resume(String name) {
        this.name = name;
        work = new WorkExperience();
    }
    public Resume(WorkExperience work) {
        this.work = work.cloneObject();
    }


    public void setPersonalInfo(String age, String sex){
        this.age = age;
        this.sex =  sex;
    }

    public void setWorkExperience(String timeArea, String company){
        work.timeArea = timeArea;
        work.company = company;
    }

    public void display(){
        System.out.println(name + " "+sex + " "+ age +"工作经历: " + work.timeArea +":" + work.company);
    }

    public Resume cloneResume(){
        Resume resume = new Resume(this.work);
        resume.name = this.name;
        resume.age = this.age;
        resume.sex = this.sex;
        return resume;
    }

}
