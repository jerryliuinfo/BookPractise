package com.apache.book.effective_java.observer;

/**
 * Created by 01370340 on 2018/11/17.
 */
public class MyDataSetObservable extends MyObservable<MyDataSetObserver> {

    public void notifyChange(){
        synchronized (mObservers){
            for (int i = mObservers.size() - 1; i >= 0; i--) {
                mObservers.get(i).onChanged();
            }
        }
    }

    public void notifyInvalidate(){
        synchronized (mObservers){
            for (int i = 0; i < mObservers.size(); i++) {
                mObservers.get(i).onInvalid();
            }
        }
    }
}
