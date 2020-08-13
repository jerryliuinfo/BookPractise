package com.apache.book.dahuadesignmode.visitor;

/**
 * Created by 01370340 on 2017/10/29.
 */

public abstract class Action {

    public abstract void getManConclusion(Man man);

    public abstract void getWomanConclusion(Woman woman);


    public abstract String getStates();
}
