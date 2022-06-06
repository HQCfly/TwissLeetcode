package com.twiss.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU缓存
 * @Author: Twiss
 * @Date: 2022/6/6 10:18 上午
 */
public class LRUCache {

    int capacity;
    Map<Integer,LinkedList> cacheMap;
    DoubleLinkedList cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.cache = new DoubleLinkedList();
    }

    public int get(int key) {
        // 如果map中存在则先将key制为活跃key，然后返回map
        if (cacheMap.containsKey(key)){
            makeRecentlyKey(key);
            return cacheMap.get(key).val;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)){
            deleteKey(key);
        }
        int size = cache.getSize();
        if (size==capacity){
            // 删除头节点
            LinkedList node = cache.removeHead();
            cacheMap.remove(node.val);
        }
        addRecently(key,value);
    }

    private void deleteKey(int key){
        LinkedList node = cacheMap.get(key);
        cacheMap.remove(key);
        cache.remove(node);
    }

    private void addRecently(int key,int val){
        LinkedList node = new LinkedList(key,val);
        cacheMap.put(key,node);
        cache.add(node);
    }

    public void makeRecentlyKey(int key){
        LinkedList node = cacheMap.get(key);
        // cache删除
        cache.remove(node);
        // cache在添加
        cache.add(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(2));
        cache.put(5,5);
        System.out.println(cache.get(1));
    }

}

// 双端链表
class DoubleLinkedList{
    LinkedList head,tail;
    int size;

    public DoubleLinkedList(){
        head = new LinkedList(0,0);
        tail = new LinkedList(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void add(LinkedList node){
        LinkedList tmp = tail.pre;
        tmp.next = node;
        node.pre = tmp;
        tail.pre = node;
        node.next = tail;
        size++;
    }

    public void remove(LinkedList node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }

    public LinkedList removeHead(){
        if (head==tail){
            return null;
        }
        LinkedList first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }
}

// 链表
class LinkedList{
    LinkedList pre;
    LinkedList next;
    int key,val;

    public LinkedList(int key,int val){
        this.key = key;
        this.val = val;
    }
}