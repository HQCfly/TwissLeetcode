package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU缓存
 *
 * @Author: Twiss
 * @Date: 2022/3/17 12:18 下午
 */
public class LRUCache5 {

    private HashMap<Integer,Node5> hashMap;
    private DoubleLinkList5 cache;
    private int cap;

    public LRUCache5(int cap){
        this.hashMap = new HashMap<>();
        this.cache = new DoubleLinkList5();
        this.cap = cap;
    }

    public int get(int key){
        if (hashMap.containsKey(key)){
            makeRecently(key);
            return hashMap.get(key).val;
        }else {
            return -1;
        }
    }

    private void makeRecently(int key){
        Node5 tmp = hashMap.get(key);
        cache.remove(tmp);
        cache.add(tmp);
    }

    public void put(int key,int val){
        if (hashMap.containsKey(key)){
            deleteKey(key);
        }
        int size = cache.getSize();
        if (cap==size){
            Node5 tmp = cache.removeHead();
            hashMap.remove(tmp.key);
        }
        addRecently(key,val);
    }

    private void deleteKey(int key){
        Node5 tmp = hashMap.get(key);
        cache.remove(tmp);
        hashMap.remove(tmp.key);
    }

    private void addRecently(int key,int val){
        Node5 tmp = new Node5(key,val);
        hashMap.put(key,tmp);
        cache.add(tmp);
    }

    public static void main(String[] args) {
        LRUCache5 lruCache5 = new LRUCache5(2);
        lruCache5.put(2,2);
        lruCache5.put(1,1);
        lruCache5.put(3,3);
        lruCache5.put(4,4);
        System.out.println(lruCache5.get(1));
    }
}

class DoubleLinkList5 {

    Node5 head, tail;
    int size;

    public DoubleLinkList5() {
        head = new Node5(0, 0);
        tail = new Node5(0, 0);
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        size = 0;
    }

    public void add(Node5 node) {
        Node5 tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        node.next = tail;
        size++;
    }

    public void remove(Node5 node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public Node5 removeHead(){
        if (head==tail){
            return null;
        }
        Node5 first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }

}

class Node5 {
    int key, val;
    Node5 pre, next;

    public Node5(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
