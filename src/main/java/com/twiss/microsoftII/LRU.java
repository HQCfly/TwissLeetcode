package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * LRU缓存机制
 *
 * @Author: Twiss
 * @Date: 2022/2/21 10:22 下午
 */
public class LRU {

    private HashMap<Integer, Node> map;
    private DoubleLinked cache;
    int cap;

    public LRU(int capacity) {
        this.map = new HashMap<>();
        this.cache = new DoubleLinked();
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            makeRecently(key);
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    // 先从缓存中删除，然后添加到链表尾部
    private void makeRecently(int key) {
        Node recentNode = map.get(key);
        cache.remove(recentNode);
        cache.addLast(recentNode);
    }

    // 添加新元素。1、map中已经存在，则先删除在添加
    // 2、如果cap满了，则将cache的头先删除，然后再添加
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key, val);
            return;
        }
        int size = cache.getSize();
        if (size == cap) {
            removeRecently(key);
        }
        addRecently(key,val);
    }

    private void removeRecently(int key) {
        Node leastNode = cache.removeHead();
        map.remove(leastNode.key);
    }

    private void deleteKey(int key) {
        cache.remove(map.get(key));
        map.remove(key);
    }

    private void addRecently(int key, int val) {
        Node tmp = new Node(key, val);
        map.put(key, tmp);
        cache.addLast(tmp);
    }

    public static void main(String[] args) {

    }
}

class DoubleLinked {

    // 构造伪头节点和尾节点
    Node head, tail;
    // 链表的size
    int size;

    public DoubleLinked() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    // 添加节点到尾部，尾部表示最新使用
    public void addLast(Node x) {
        x.next = tail;
        x.pre = tail.pre;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    // 删除节点
    public void remove(Node x) {
        x.next.pre = x.pre;
        x.pre.next = x.next;
        size--;
    }

    // 删除头部，头部表示最少使用并返回头节点
    public Node removeHead() {
        if (head == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    // 返回size
    public int getSize() {
        return size;
    }
}

class Node {

    int key, val;
    // 设置pre和next
    Node pre, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
