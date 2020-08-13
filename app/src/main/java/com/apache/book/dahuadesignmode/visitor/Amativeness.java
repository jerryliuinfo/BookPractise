package com.apache.book.dahuadesignmode.visitor;

/**
 * Created by Jerry on 2019/1/6.
 */
public class Amativeness extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("男人"+getStates() +" 时，凡事不懂也装懂");
    }

    @Override
    public void getWomanConclusion(Woman woman) {
        System.out.println("女人"+getStates() +" 时，遇事懂也装不懂");
    }

    @Override
    public String getStates() {
        return "恋爱";
    }
}
