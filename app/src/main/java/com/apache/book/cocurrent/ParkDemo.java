package com.apache.book.cocurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Jerry on 2020-04-20.
 */
public class ParkDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                testSync();
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("thread: %s  run ",Thread.currentThread().getName()));
        LockSupport.unpark(t1);
    }


    public static void testSync(){
        long startTime = System.currentTimeMillis();
        System.out.println(String.format("thread: %s run, time: %s", Thread.currentThread().getName(),System.currentTimeMillis()));
        LockSupport.park();

        System.out.println(String.format("thread: %s  end, cost time %s ms", Thread.currentThread().getName(),(System.currentTimeMillis() - startTime)));




    }
}
