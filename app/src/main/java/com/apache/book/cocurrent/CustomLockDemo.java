package com.apache.book.cocurrent;

/**
 * Created by Jerry on 2020-04-20.
 */
public class CustomLockDemo {

    private volatile int status = 0;

    public static void main(String[] args) {
        final CustomLockDemo demo = new CustomLockDemo();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                super.run();
                demo.testSync();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                demo.testSync();
            }
        };
        t2.setName("t2");

        t1.start();
        t2.start();
    }

    public  void testSync(){
        long startTime = System.currentTimeMillis();
        System.out.println(String.format("thread: %s begin run", Thread.currentThread().getName()));
        lock();
        System.out.println(String.format("thread: %s lock end, cost time: %s ms", Thread.currentThread().getName(),(System.currentTimeMillis() -startTime)));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            unLock();
        }
    }

    public void lock(){
        System.out.println(String.format("thread: %s begin lock ",Thread.currentThread().getName()));
        long startTime = System.currentTimeMillis();
        /**
         * 缺点：这里死循环，耗费cpu资源，没有竞争到锁的线程会一直占用cpu资源进行cas操作，
         * 例如某个线程获得锁后需要花费NS处理业务逻辑，那另外一个线程就会白白的花费NS的cupu
         * 思路：让得不到锁的线程让出CPU
         */
        while (!compareAndSet(0,1)){
            /**
             * yield自旋转 解决自旋锁的性能问题必须让竞争失败的线程不空转而把cpu让出来
             * 当系统只有两个线程竞争锁时，yield是有有效的，但是多个线程时，不一定有效，因为下一次的时候
             * 有可能操作系统还是选择运行该线程
             */
            //yield() ;//

            /**
             * sleep 自旋
             * 缺点：无法知道需要睡眠的时间应该是多少
             */
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }




        }
        System.out.println(String.format("thread: %s end lock cost time: %s ms",Thread.currentThread().getName(),(System.currentTimeMillis() - startTime)));

    }

    public void unLock(){
        System.out.println(String.format("thread: %s unLock",Thread.currentThread().getName()));
        status = 0;
    }

    public boolean compareAndSet(int expect,int value){
        //cas 操作，修改status成功返回true，否则返回false
        if (status == expect){
            status = value;
            return true;
        }
        return false;
    }


}
