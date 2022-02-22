package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU 缓存
 *
 * @Author: Twiss
 * @Date: 2022/2/22 3:13 下午
 */
public class LRUCache {

    private HashMap<Integer, LruNode> map;
    private DoubleLinkedNode cache;
    private int cap;

    public LRUCache(int capacity){
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedNode();
        this.cap = capacity;
    }

    public void put(int key,int val){
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
        }
        int size = cache.getSize();
        if (size==cap){
            // 先进行删除头节点，在进行map删除
            LruNode rKey = cache.removeHead();
            map.remove(rKey.key);
        }
        addRecently(key,key);
    }

    public int get(int key){
        if (map.containsKey(key)){
            makeRecently(key);
            return map.get(key).val;
        }else {
            return -1;
        }
    }

    public void makeRecently(int key){
        LruNode newKey = map.get(key);
        cache.removeKey(newKey);
        cache.addLast(newKey);
    }

    public void deleteKey(int key){
        LruNode newKey = map.get(key);
        cache.removeKey(newKey);
        map.remove(key);
    }

    public void addRecently(int key, int val){
        LruNode newKey = new LruNode(key,val);
        cache.addLast(newKey);
        map.put(key,newKey);
    }

    public static void main(String[] args) {
        LRUCache lruNode = new LRUCache(4);
        lruNode.put(1,1);
        lruNode.put(2,2);
        lruNode.put(3,3);
        lruNode.put(4,4);
        lruNode.put(5,5);
        int res = lruNode.get(1);
        System.out.println(res);
    }
}

class DoubleLinkedNode {

    LruNode head, tail;
    int size = 0;

    public DoubleLinkedNode() {
        head = new LruNode(0, 0);
        tail = new LruNode(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void removeKey(LruNode key) {
        key.pre.next = key.next;
        key.next.pre = key.pre;
        size--;
    }

    public LruNode removeHead() {
        if (head == tail) {
            return null;
        }
        LruNode first = head.next;
        removeKey(first);
        return first;
    }

    public void addLast(LruNode key) {
        tail.pre.next = key;
        key.pre = tail.pre;
        key.next = tail;
        tail.pre = key;
        size++;
    }

    public int getSize() {
        return size;
    }

}

class LruNode {

    LruNode pre, next;
    int key, val;

    public LruNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}