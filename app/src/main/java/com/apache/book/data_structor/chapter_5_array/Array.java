package com.apache.book.data_structor.chapter_5_array;

import java.util.Arrays;

/**
 * Created by Jerry on 2020-04-13.
 */
public class Array {

    public int data[];

    private int n; //数组长度

    private int count; //实际个数

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        count = 0;
    }

    public int find(int index){
        if (index < 0 || index > count){
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value){
        if (count == n){
            System.out.println("数组已满，无法插入");
            return false;
        }
        if (index < 0 || index > count){
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; --i){
            System.out.println(String.format("i: %s, data[%s]:%s, data[i -1]: %s",i,i,data[i],data[i-1]));
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }


    public boolean delete(int index){
        if (index < 0 || index >= count){
            return false;
        }
        for (int i = index +1; i< count;i++){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }


    public static void main(String[] args) {
        int capiticy = 10;
        Array array = new Array(capiticy);
        for (int i = 0; i < 8; i++) {
            array.insert(i,i+1 );
        }
        System.out.println("before insert:"+Arrays.toString(array.data));
        array.insert(4,20);
        System.out.println("after insert:"+Arrays.toString(array.data));

        array.delete(1);
        System.out.println("after delete:"+Arrays.toString(array.data));


    }


}
