package com.twiss.zijie;

import java.util.HashMap;

/**
 * LRU缓存
 * 时间复杂度O()
 * 空间复杂度O()
 *
 * @Author: Twiss
 * @Date: 2022/3/30 4:03 下午
 */
public class LRUCache {

    HashMap<Integer,LRUNode> map;
    DoubleLinkedList cache;
    int capacity;

    public LRUCache(int cap){
        this.capacity = cap;
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedList();
    }

    public void put(int key,int val){
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        int size = cache.getSize();
        if (size==capacity){
            deleteHead();
        }
        addRecently(key,val);
    }

    public int get(int key){
        if (map.containsKey(key)){
            makeRecently(key);
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    private void addRecently(int key,int val){
        LRUNode tmp = new LRUNode(key,val);
        cache.addLast(tmp);
        map.put(key,tmp);
    }

    private void makeRecently(int key){
        LRUNode node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    private void deleteHead(){
        LRUNode tmp = cache.removeHead();
        map.remove(tmp.key);
    }

    private void deleteKey(int key){
        LRUNode tmp = map.get(key);
        cache.remove(tmp);
        map.remove(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
        lruCache.put(3,3);
        System.out.println(lruCache.get(2));
    }
}

class DoubleLinkedList {

    LRUNode head, tail;
    int size;

    public DoubleLinkedList() {
        head = new LRUNode(0, 0);
        tail = new LRUNode(0, 0);
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        size = 0;
    }

    public void addLast(LRUNode node){
        LRUNode tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        node.next = tail;
        tail.pre = node;
        size++;
    }

    public void remove(LRUNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        size--;
    }

    public LRUNode removeHead(){
        if (head==tail){
            return null;
        }
        LRUNode first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }
}

class LRUNode {
    int key, val;
    LRUNode pre, next;

    public LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}