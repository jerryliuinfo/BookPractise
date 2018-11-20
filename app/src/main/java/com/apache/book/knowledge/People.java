package com.apache.book.knowledge;

/**
 * Created by 01370340 on 2018/11/18.
 */
public class People implements Cloneable{

    public String name;

    public Occupation occupation;



    @Override
    protected Object clone()  {
        try {
            super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null ;
    }

    public static class Occupation{
        public String company;
    }
}
