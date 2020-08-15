package com.apache.book.arithmetic;

import java.util.HashMap;

/**
 * author: jerry
 * created on: 2020/8/15 4:52 PM
 * description:
 */
public class LruCache {
    public static final String TAG = LruCache.class.getSimpleName();
    int capiticy;

    HashMap<Integer,LinkNode> map = new HashMap<>();
    LinkNode header = new LinkNode(0,0);
    LinkNode tail = new LinkNode(0,0);

    public LruCache(int capiticy) {
        this.capiticy = capiticy;
        header.next = tail;
        tail.front = header;
    }

    public static void main(String[] args) {

        LruCache cache = new LruCache(2);
        cache.put(1,1);
        cache.put(2,2);

        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));


        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }


    public int get(int key){
        if (map.containsKey(key)){
            LinkNode node = map.get(key);
            moveToTop(node);
            return node.value;
        }
        return -1;
    }


    public void put(int key, int value){
        //如果没有包含了该元素
        if (!map.containsKey(key)){
            //已经超过了容量，则删除最后的，然后将新的元素插入到最前面
            if (map.size() == capiticy){
                // 删除最后一个节点
                deleteLastNode();
            }
            LinkNode temp = header.next;
            LinkNode newNode = new LinkNode(key,value);

            header.next = newNode;
            newNode.front = header;

            newNode.next = temp;
            temp.front = newNode;
            map.put(key,newNode);
        }
        //如果已经包含了，则将元素移动到最前面
        else {
            LinkNode node = map.get(key);
            node.value = value;
            moveToTop(node);
        }
    }

    //0 1 2 3 4 将3移动到最前面 变成 3 0 1 2 4
    private void moveToTop(LinkNode node) {
        //将2 指向 4
        node.front.next = node.next;
       //将4 指向 2
        node.next.front = node.front;

        //0
        LinkNode temp = header.next;

        header.next = node;
        //header 3
        node.front = header;

        //header 3 0
        node.next = temp;
        temp.front = node;




    }

    private void deleteLastNode() {
        //先将最后一个节点删掉
        LinkNode lastNode = tail.front;
        System.out.println(String.format("deleteLastNode: key: %s, value:%s",
                lastNode.key,lastNode.value ));

        lastNode.front.next = tail;
        tail.front = lastNode.front;
        map.remove(lastNode.key);

    }


    class LinkNode{
        int key;
        int value;
        LinkNode front;
        LinkNode next;

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("{");
            sb.append("\"key\":")
                    .append(key);
            sb.append(",\"value\":")
                    .append(value);
            sb.append(",\"front\":")
                    .append(front);
            sb.append(",\"next\":")
                    .append(next);
            sb.append('}');
            return sb.toString();
        }

        public LinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }




}
