package com.apache.book.cocurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jerry on 2020-04-20.
 */
public class ReentrantLockDemo {
    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                testSync();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                testSync();
            }
        };
        t2.setName("t2");

        t1.start();
        t2.start();
    }


    public static void testSync(){
        reentrantLock.lock();
        System.out.println(String.format("thread: %s run, time: %s", Thread.currentThread().getName(),System.currentTimeMillis()));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
    }
}
