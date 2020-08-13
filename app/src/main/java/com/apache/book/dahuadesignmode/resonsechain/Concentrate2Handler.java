package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class Concentrate2Handler extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request > 10 && request <= 20){
            System.out.println("Concentrate2Handler handleRequest request = "+ request);
        }else if (succcesor != null){
            succcesor.handleRequest(request);
        }
    }
}
