package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class Concentrate1Handler extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request <= 10){
            System.out.println("Concentrate1Handler handleRequest request = "+ request);
        }else if (succcesor != null){
            succcesor.handleRequest(request);
        }
    }
}
