package com.apache.book.arithmetic;

import java.util.Stack;

/**
 * author: jerry
 * created on: 2020/8/16 8:58 PM
 * description:
 */
class QueueDemo {
    public static void main(String[] args) {
        QueueDemo demo = new QueueDemo();
        demo.push(1);
        demo.push(2);
        demo.push(3);
        demo.push(4);

        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
        System.out.println(demo.pop());
    }
    //后进先出
    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();

    public void push(int node){
        tail.push(node);
    }

    public int pop(){
        if (head.isEmpty()){
            if (tail.isEmpty()){
                return -1;
            }
            while (!tail.isEmpty()){
                head.push(tail.pop());
            }
        }
        return head.pop();
    }

    /**
     * 用两个栈实现队列
     */
    private static void realizeDequeByTwoStack(){

    }
}
