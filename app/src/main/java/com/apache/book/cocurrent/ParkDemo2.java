package com.apache.book.cocurrent;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Jerry on 2020-04-20.
 */
public class ParkDemo2 {
    volatile int status;
    Queue<Thread> parkQueue;


    public static void main(String[] args) {
        final ParkDemo2 demo2 = new ParkDemo2();
        demo2.parkQueue = new LinkedBlockingDeque<>();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                demo2.testSync();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                demo2.testSync();
            }
        };
        t2.setName("t2");

        t1.start();
        t2.start();
    }

    void lock(){
        while (!compareAndSet(0,1)){
            park();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        unlock();
    }

    void unlock(){
        status = 1;
        lock_notify();
    }

    void park(){
        parkQueue.add(Thread.currentThread());
        releaseCpu();
    }

    private void releaseCpu() {

    }

    void lock_notify(){
        Thread t = parkQueue.poll();
        LockSupport.unpark(t);
    }

    private boolean compareAndSet(int expect,int value){
        if (expect == status){
            status = value;
            return true;
        }
        return false;
    }


    public  void testSync(){

        lock();


    }
}
