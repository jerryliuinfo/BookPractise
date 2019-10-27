package com.apache.book.arithmetic;

import java.util.Arrays;

/**
 * Created by Jerry on 2019-10-27.
 */
public class ArrayQueue {

    private String[] items;

    private int n;

    private int head;

    private int tail;

    public ArrayQueue(int capcity){
        items = new String[capcity];
        n = capcity;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        if (tail == n){

            if (head == 0){
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }

            tail-= head;
            head = 0;

        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue(){
        if (head == tail){
            return null;
        }
        String ret = items[head];
        items[head] = null;
        ++head;
        return  ret;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"items\":").append(Arrays.toString(items));
        sb.append(",\"head\":").append(head);
        sb.append(",\"tail\":").append(tail);
        sb.append('}');
        return sb.toString();
    }
}
