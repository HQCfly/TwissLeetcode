package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU缓存
 * @Author: Twiss
 * @Date: 2022/3/6 1:35 下午
 */
public class LRUCache4 {

    HashMap<Integer,Node4> map;
    DoubleLinked4 cache;
    int cap;

    public LRUCache4(int cap){
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleLinked4();
    }

    public void put(int key, int val){
        if (map.containsKey(key)){
            // 先删除
            deleteKey(key);
            // 再添加
            addRecently(key,val);
        }

        int size = cache.getSize();
        if (size==cap){
            deleteHead();
        }
        addRecently(key,val);
    }

    private void deleteHead(){
        Node4 node = cache.removeHead();
        map.remove(node.key);
    }

    private void deleteKey(int key){
        Node4 node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void addRecently(int key,int val){
        Node4 node = new Node4(key,val);
        map.put(key,node);
        cache.add(node);
    }

    public int get(int key){
        if (map.containsKey(key)){
            makeRecently(key);
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    private void makeRecently(int key){
        Node4 node = map.get(key);
        // 先删除缓存中的值
        cache.remove(node);
        // 再添加
        cache.add(node);
    }

    public static void main(String[] args) {
        LRUCache4 lruCache4 = new LRUCache4(2);
        lruCache4.put(1,1);
        lruCache4.put(2,2);
        System.out.println(lruCache4.get(1));
        lruCache4.put(3,3);
        System.out.println(lruCache4.get(2));
    }
}

class DoubleLinked4{

    Node4 head,tail;
    private int size;

    public DoubleLinked4(){
        this.size = 0;
        this.head = new Node4(0,0);
        this.tail = new Node4(0,0);
        head.next = tail;
        tail.pre = head;
    }

    public void add(Node4 node){
        tail.pre.next = node;
        node.pre = tail.pre;

        node.next = tail;
        tail.pre = node;
        size++;
    }

    public void remove(Node4 node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public Node4 removeHead(){
        if (head==tail){
            return null;
        }
        Node4 first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }
}

class Node4{
    int key,val;
    Node4 pre,next;
    public Node4(int key,int val){
        this.key = key;
        this.val = val;
    }
}