package com.apache.book.dahuadesignmode.dimterule;

/**
 * Created by lenovo on 2016/11/6.
 */

public class Employee {
    IAssembleComputer assembleComputer;
    public void test(){
        if (assembleComputer != null){
            assembleComputer.assembleComputer();
        }
    }
}
