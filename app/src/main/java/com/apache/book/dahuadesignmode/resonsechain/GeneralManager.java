package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class GeneralManager extends Manager {
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void dealRequest(Request request) {
        if (request.requestType == Request.TYPE_LEAVE){
            System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 被批准");
        }
        else if (request.requestType == Request.TYPE_SALARY){
            if (request.number <= 2000){
                System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 被批准");
            }else {
                System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 再说吧");
            }
        }
    }
}
