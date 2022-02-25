package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU
 *
 * @Author: Twiss
 * @Date: 2022/2/25 2:15 下午
 */
public class LRUCacheII {

    HashMap<Integer, NodeII> map;
    DoubleLinkedII cache;
    int cap;

    public LRUCacheII(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedII();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
        }
        int size = cache.getSize();
        if (size == cap) {
            removeHeadKey();
        }
        addRecently(key, value);
    }

    private void deleteKey(int key) {
        NodeII node = map.get(key);
        cache.remove(node);
        map.remove(key);
    }

    private void addRecently(int key, int val) {
        NodeII node = new NodeII(key, val);
        cache.add(node);
        map.put(key, node);
    }

    private void removeHeadKey() {
        NodeII node = cache.removeHead();
        map.remove(node.key);
    }

    private void makeRecently(int key) {
        NodeII tmp = map.get(key);
        cache.remove(tmp);
        cache.add(tmp);
    }

    public static void main(String[] args) {
        LRUCacheII lruCacheII = new LRUCacheII(2);
        lruCacheII.put(1, 1);
        lruCacheII.put(2, 2);
        System.out.println(lruCacheII.get(1));
        lruCacheII.put(3, 3);
        System.out.println(lruCacheII.get(2));
        lruCacheII.put(4, 4);
        System.out.println(lruCacheII.get(1));
    }

}

class DoubleLinkedII {
    NodeII tail, head;
    int size;

    public DoubleLinkedII() {
        head = new NodeII(0, 0);
        tail = new NodeII(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public void add(NodeII nodeII) {
        nodeII.next = tail;
        tail.pre.next = nodeII;
        nodeII.pre = tail.pre;
        tail.pre = nodeII;
        tail.next = null;
        size++;
    }

    public void remove(NodeII nodeII) {
        nodeII.pre.next = nodeII.next;
        nodeII.next.pre = nodeII.pre;
        size--;
    }

    public NodeII removeHead() {
        if (head == tail) {
            return null;
        }
        NodeII first = head.next;
        remove(first);
        return first;
    }

    public int getSize() {
        return size;
    }
}

class NodeII {

    NodeII pre, next;
    int key, val;

    public NodeII(int key, int val) {
        this.key = key;
        this.val = val;
    }

}