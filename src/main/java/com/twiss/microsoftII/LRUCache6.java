package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU缓存
 * @Author: Twiss
 * @Date: 2022/8/9 1:21 下午
 */
public class LRUCache6 {

    private HashMap<Integer,Node6> hashMap;
    private DoubleLinkedListLru6 cache;
    private int cap;

    public LRUCache6(int cap){
        this.cap = cap;
        hashMap = new HashMap<>();
        cache = new DoubleLinkedListLru6();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)){
            makeRecently(key);
            return hashMap.get(key).val;
        }else {
            return -1;
        }
    }

    public void put(int key,int val){
        if (hashMap.containsKey(key)){
            deleteKey(key);
        }
        int size = cache.getSize();
        if (cap==size){
            Node6 tmp = cache.removeHead();
            hashMap.remove(tmp.key);
        }
        addRecently(key,val);
    }

    private void makeRecently(int key){
        Node6 tmp = hashMap.get(key);
        cache.remove(tmp);
        cache.add(tmp);
    }

    private void deleteKey(int key){
        Node6 tmp = hashMap.get(key);
        cache.remove(tmp);
        hashMap.remove(key);
    }

    private void addRecently(int key,int val){
        Node6 tmp = new Node6(key,val);
        cache.add(tmp);
        hashMap.put(key,tmp);
    }


    public static void main(String[] args) {
        LRUCache6 lruCache6 = new LRUCache6(2);
        lruCache6.put(2,2);
        lruCache6.put(1,1);
        lruCache6.put(3,3);
        lruCache6.put(4,4);
        System.out.println(lruCache6.get(1));
    }
}

class DoubleLinkedListLru6{

    Node6 head,tail;
    int size;

    public DoubleLinkedListLru6(){
        this.head = new Node6(0,0);
        this.tail = new Node6(0,0);
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        size = 0;
    }

    public void add(Node6 node){
        Node6 tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        node.next = tail;
        tail.pre = node;
        size++;
    }

    public void remove(Node6 node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public Node6 removeHead(){
        if (tail==head){
            return null;
        }
        Node6 first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}

class Node6{
    int key, val;
    Node6 pre,next;

    public Node6(){

    }
    public Node6(int key,int val){
        this.key = key;
        this.val = val;
    }
}


