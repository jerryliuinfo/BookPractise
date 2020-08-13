package com.apache.book.dahuadesignmode.mediator;

/**
 * Created by jerryliu on 2017/8/30.
 */

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void send(String message);

    public abstract void notify(String message);


    public Mediator getMediator() {
        return mediator;
    }
}
