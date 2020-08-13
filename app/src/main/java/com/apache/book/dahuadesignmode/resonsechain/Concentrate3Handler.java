package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class Concentrate3Handler extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request > 20){
            System.out.println("Concentrate3Handler handleRequest request = "+ request);
        }else if (succcesor != null){
            succcesor.handleRequest(request);
        }
    }
}
