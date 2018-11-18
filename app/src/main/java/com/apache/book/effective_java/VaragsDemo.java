package com.apache.book.effective_java;

/**
 * Created by 01370340 on 2018/11/16.
 */
public class VaragsDemo {

    public static void main(String[] args) {
        foo();
        foo(1);
        foo(1,2);
        foo(1,2,3);
        foo(1,2,3,4);
    }


    public static void foo(){
        System.out.println("foo()");
    }

    public static void foo(int a1){
        System.out.println("foo(int a1)");

    }

    public static void foo(int a1, int a2){
        System.out.println("foo(int a1, int a2)");

    }

    public static void foo(int a1, int a2,int a3){
        System.out.println("foo(int a1, int a2,int a3)");
    }

    public static void foo(int a1, int a2,int a3, int ...rest){
        System.out.println("foo(int a1, int a2,int a3, int ...rest)");

    }
}
