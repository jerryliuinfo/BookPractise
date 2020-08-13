package com.hawk.design.other.person;

import com.hawk.design.other.dest.AbsDestination;
import com.hawk.design.other.transport.ITransportation;

/**
 * Created by 01370340 on 2017/9/25.
 */

public abstract class Person {
    private ITransportation transportation;

    private AbsDestination destination;


    public ITransportation getTransportation() {
        return transportation;
    }

    public void setTransportation(ITransportation transportation) {
        this.transportation = transportation;
    }

    public AbsDestination getDestination() {
        return destination;
    }

    public void setDestination(AbsDestination destination) {
        this.destination = destination;
    }

    public void startOff(){
        beforeTranslate();
        transportation.transporte();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("目的地;"+ destination.getAddressName());
    }


    public abstract void beforeTranslate();
}
