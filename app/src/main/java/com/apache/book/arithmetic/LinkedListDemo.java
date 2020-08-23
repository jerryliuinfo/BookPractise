package com.apache.book.arithmetic;

import java.util.Deque;
import java.util.LinkedList;

/**
 * author: jerry
 * created on: 2020/8/15 6:21 PM
 * description:链表反转
 * 1    -> 2 -> 3 -> 4 -> 5 -> null 转换成
 * pre    cur  temp
 * null -> 1 ->  2   -> 3 -> 4 -> 5
 *
 *
 * 思路1： 头插法  链表的特点决定：基本思路一定是遍历 Time: O(N) Space:0
 * 思路2： 栈
 *
 * 头插法思路
 * 1.暂存 用temp暂存 cur.next
 * 2.指向 cur.next = pre  将1 指向 null (由1 -> 2 改为 1 -> null)
 * 3.归位 pre  指向到 cur, cur 指向到 temp， temp 指向到cur.next
 * pre = cur
 * cur = temp
 * 停止遍历的条件: cur 为null
 */
class LinkedListDemo {

    /**
     * 链表反转
     * 头插法： 3步骤
     *
     * @param head
     */
    private static LinkNode reverseList(LinkNode head){
        //初始设定 前一个节点指针
        LinkNode pre = null;
        //当前节点指针
        LinkNode cur = head;

        //终止条件
        while (cur != null){
            //1. 暂存下一个节点指针
            LinkNode temp = cur.next;
            //2. 指向
            cur.next = pre;
            //3. 归位(先归pre, 最后cur)
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 链表反转：栈的方式
     * @param head
     * @return
     */
    private static LinkNode reverseListByStack(LinkNode head) {
        //借助栈
        Deque<LinkNode> stack = new LinkedList();
        LinkNode newHead=null;  //返回的逆转栈

        //安全验证
        if(head == null) return null;
        if(head.next == null) return head;

        //一个个入栈
        while(head!=null){
            stack.push(head);
            head = head.next;
        }

        head = stack.pop();
        LinkNode cur = head;
        //出栈
        while(!stack.isEmpty()){
            LinkNode node = stack.pop();
            //我们虽然正向存入了栈中，但是每个节点的next的指向还没变，在这里要消除
            node.next=null;  //这一步关键（//消除正向原本的指向关系）
            cur.next = node;
            cur = node;
        }

        return head;
    }

    public static void main(String[] args) {
        LinkNode header = new LinkNode(1);

        LinkNode node2 = new LinkNode(2);
        header.next = node2;
        LinkNode node3 = new LinkNode(3);
        node2.next = node3;
        LinkNode node4 = new LinkNode(4);
        node3.next = node4;
        LinkNode node5 = new LinkNode(5);
        node4.next = node5;

        System.out.println("before reverse:" + header);

        LinkNode newNode;
        //newNode = reverseList(header);
       //System.out.println("after reverse by 头插法:" + newNode);

        //用栈做链表反转
       // newNode = reverseListByStack(header);
        //System.out.println("after reverse by stack:" + newNode);

        newNode = findKthToTail(header,3);
        System.out.println("after findKthToTail :" + newNode.value);



    }


    /**
     * 链表反转
     */
    private static void testReverseList(LinkNode header){
        LinkNode newNode;
        newNode = reverseList(header);
        System.out.println("after reverse by stack:" + newNode);

    }





    /**
     *  找出倒数第K个节点
     *  有两个指针，先让第一个指针往前走 k 步
     *  第一个指针和第二个指针同时往前走，直到第一个指针走到了末尾， 说明就是倒数第K个了
     */
    private static LinkNode findKthToTail(LinkNode head, int k){
        //
        LinkNode first = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        LinkNode second = head;
        while (first != null){
            first = first.next;
            second = second.next;
        }
        return second;
    }












    private static class LinkNode{
        int value;
        LinkNode next;


        public LinkNode(int value){
            this.value = value;
        }

        public void addNode(LinkNode node){
            this.next = node;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"value\":")
                    .append(value);
            sb.append(",\"next\":")
                    .append(next);
            sb.append('}');
            return sb.toString();
        }
    }
}
