package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class CommonManager extends Manager {
    public CommonManager(String name){
        super(name);
    }
    @Override
    public void dealRequest(Request request) {
        if (request.requestType == Request.TYPE_LEAVE){
            if (request.number <= 2){
                System.out.println(name + ":" + request.requestContent +",数量:"+request.number +" 被批准");
            }else if (superior != null){
                superior.dealRequest(request);
            }
        }
        //经理无权处理加薪请求
        else if (request.requestType == Request.TYPE_SALARY){
            if (superior != null){
                superior.dealRequest(request);
            }
        }
    }
}
