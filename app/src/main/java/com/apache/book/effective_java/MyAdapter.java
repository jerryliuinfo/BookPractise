package com.apache.book.effective_java;

import com.apache.book.effective_java.observer.MyDataSetObservable;
import com.apache.book.effective_java.observer.MyDataSetObserver;

/**
 * Created by 01370340 on 2018/11/17.
 */
public class MyAdapter {
    private final MyDataSetObservable myDataSetObservable = new MyDataSetObservable();


    public void registerDataSetObserver(MyDataSetObserver observer){
        myDataSetObservable.registObserver(observer);
    }

    public void unregisterDataSetObserver(MyDataSetObserver observer){
        myDataSetObservable.unRegistObserver(observer);
    }

    public void notifyDataSetChanged(){
        myDataSetObservable.notifyChange();
    }

    public void notifyDataSetInvalidated(){
        myDataSetObservable.notifyInvalidate();
    }


}
