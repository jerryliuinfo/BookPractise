package com.apache.book.dahuadesignmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jerry
 * @Description:
 * @date 2016/12/4 14:29
 * @copyright TCL-MIG
 */

public abstract class Notifier {
    protected List<Observer> observers = new ArrayList<>();
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }
    public void notifyObserver(){
        for(Observer o: observers){
            o.update();
        }
    }
   abstract String getAction();
}
