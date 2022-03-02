package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * 缓存
 * @Author: Twiss
 * @Date: 2022/3/2 1:06 下午
 */
public class LRUCacheIII {

    private HashMap<Integer,LRUNodeII> map;
    private DoubleLinkedNodeII cache;
    private int cap;

    public LRUCacheIII(int capacity){
        map = new HashMap<>();
        cache = new DoubleLinkedNodeII();
        cap = capacity;
    }

    public void put(int key,int val){
        if (map.containsKey(key)){
            deleteKey(key);
            addKey(key,val);
        }

        int size = cache.getSize();
        if (size==cap){
            deleteHead();
        }
        addKey(key,val);
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
        LRUNodeII node = map.get(key);
        cache.remove(node);
        cache.add(node);
    }

    public void deleteKey(int key){
        LRUNodeII node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    public void deleteHead(){
        LRUNodeII node = cache.removeHead();
        map.remove(node.key);
    }

    public void addKey(int key,int val){
        LRUNodeII nodeII = new LRUNodeII(key,val);
        cache.add(nodeII);
        map.put(key,nodeII);
    }

    public static void main(String[] args) {
        LRUCacheIII lruCacheIII = new LRUCacheIII(2);
        lruCacheIII.put(1, 1);
        lruCacheIII.put(2, 2);
        System.out.println(lruCacheIII.get(1));
        lruCacheIII.put(3, 3);
        System.out.println(lruCacheIII.get(2));
        lruCacheIII.put(4, 4);
        System.out.println(lruCacheIII.get(1));
    }
}

class DoubleLinkedNodeII{

    int size;
    LRUNodeII head, tail;

    public DoubleLinkedNodeII(){
        head = new LRUNodeII(0,0);
        tail = new LRUNodeII(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void add(LRUNodeII newNode){
        LRUNodeII tmp = tail.pre;
        tmp.next = newNode;
        newNode.pre = tmp;
        newNode.next = tail;
        tail.pre = newNode;
        tail.next = null;
        size++;
    }

    public void remove(LRUNodeII node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
        size--;
    }

    public LRUNodeII removeHead(){
        if (head==tail){
            return null;
        }
        LRUNodeII first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }
}

class LRUNodeII{
    int key,val;
    LRUNodeII pre,next;

    public LRUNodeII(int key,int val){
        this.key = key;
        this.val = val;
    }
}