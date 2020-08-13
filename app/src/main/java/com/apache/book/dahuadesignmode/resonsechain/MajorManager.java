package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class MajorManager extends Manager {
    public MajorManager(String name) {
        super(name);
    }

    @Override
    public void dealRequest(Request request) {
        if (request.requestType == Request.TYPE_LEAVE){
            if (request.number <= 5){
                System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 被批准");
            }else if (superior != null){
                superior.dealRequest(request);
            }
        }
        else if (request.requestType == Request.TYPE_SALARY){
            if (request.number <= 1000){
                System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 被批准");
            }else if (superior != null){
                superior.dealRequest(request);
            }
        }
    }
}
