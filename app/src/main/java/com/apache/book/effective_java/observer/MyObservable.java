package com.apache.book.effective_java.observer;

import java.util.ArrayList;

/**
 * Created by 01370340 on 2018/11/17.
 */
public class MyObservable<T> {

    protected final ArrayList<T> mObservers = new ArrayList<>();

    public void registObserver(T observer){
        if (observer == null){
            throw new IllegalArgumentException("the observer is null");
        }

        synchronized (mObservers){
            if (mObservers.contains(observer)){
                throw new IllegalStateException("observer " + observer + " is already registed");
            }
        }
        mObservers.add(observer);
    }

    public void unRegistObserver(T observer){
        if (observer == null){
            throw new IllegalArgumentException("the observer is null");
        }

        synchronized (mObservers){
            int index = mObservers.indexOf(observer);
            if (index == -1){
                throw new IllegalStateException("observer " + observer + " was not registed");
            }
            mObservers.remove(index);
        }
    }

    public void unRegisteAll(){
        synchronized (mObservers){
            mObservers.clear();
        }
    }

}
