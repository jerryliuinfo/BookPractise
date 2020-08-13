package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public class Request {
    public static final int TYPE_SALARY = 1;
    public static final int TYPE_LEAVE = 2;
    public int requestType;
    public String requestContent;
    public int number;


    public Request(int requestType, String requestContent, int number) {
        this.requestType = requestType;
        this.requestContent = requestContent;
        this.number = number;
    }
}
