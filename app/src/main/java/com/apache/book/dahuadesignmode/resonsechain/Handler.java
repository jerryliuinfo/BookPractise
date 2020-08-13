package com.apache.book.dahuadesignmode.resonsechain;

/**
 * Created by lenovo on 2016/11/13.
 */

public abstract class Handler {
    protected Handler succcesor;
    public void setParent(Handler succcesor){
        this.succcesor = succcesor;
    }

    public abstract void handleRequest(int request);

}
