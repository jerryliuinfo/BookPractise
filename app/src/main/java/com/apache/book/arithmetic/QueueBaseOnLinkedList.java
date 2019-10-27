package com.apache.book.arithmetic;

import android.util.Log;

import com.apache.book.MainActivity;

/**
 * Created by Jerry on 2019-10-27.
 */
public class QueueBaseOnLinkedList {


    private Node tail;

    private Node head;



    public void enqueue(String value){
        if (tail == null){
            Node newNode = new Node(value,null);
            tail = newNode;
            head = newNode;
        }else {
            tail.next = new Node(value,null);
            tail = tail.next;
        }
    }

    public String dequeue(){
        if (head == null){
            return null;
        }
        String value = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            Log.d(MainActivity.TAG,p.data + " ");
            p = p.next;
        }

    }



    private static class Node{

        private String data;

        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return data;
        }
    }

}
