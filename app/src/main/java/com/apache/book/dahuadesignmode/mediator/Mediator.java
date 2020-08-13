package com.apache.book.dahuadesignmode.mediator;

/**
 * Created by jerryliu on 2017/8/30.
 */

public abstract class Mediator {
    public abstract void send(String message, Colleague colleague);
}
