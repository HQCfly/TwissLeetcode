package com.twiss.microsoft;

import java.util.HashMap;

/**
 * @Author: Twiss
 * @Date: 2022/1/12 8:38 下午
 */
public class LRU {
    HashMap<Integer,Node> map;
    DoubleLinked cache;
    int cap;

    // 初始化
    public LRU(int capacity){
        map = new HashMap<>(capacity);
        cache = new DoubleLinked();
        this.cap = capacity;
    }

    // get操作
    public int get(int key){
        // 如果map中存在，则先进行移动到链表尾部，在返回
        if (map.containsKey(key)){
            makeRecently(key);
            return map.get(key).value;
        }else {
            return -1;
        }
    }

    // put操作
    public void put(int key, int val){
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key,val);
            return;
        }
        int size = cache.getSize();
        if (size==cap){
            removeLeastRecently();
        }
        addRecently(key,val);
    }

    // 删除最久未使用的元素，最久未使用的元素一定在头部
    private void removeLeastRecently(){
        Node leastNode = cache.removeHead();
        map.remove(leastNode.key);
    }

    // 将key标记为最近使用的元素（map中存在）
    private void makeRecently(int key){
        Node x = map.get(key);
        // 先从链表删除该节点
        cache.remove(x);
        // 在链接尾部添加该节点
        cache.addLast(x);
    }

    // 添加最近使用元素，map中不存在
    private void addRecently(int key,int val){
        Node x = new Node(key,val);
        map.put(key,x);
        cache.addLast(x);
    }

    // 删除key
    private void deleteKey(int key){
        cache.remove(map.get(key));
        map.remove(key);
    }
}

class DoubleLinked{
    // 构造伪头尾节点
    Node head,tail;
    // 双向链表的size
    int size;

    // 初始化
    public DoubleLinked(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    // 添加节点到尾部，尾部表示最新使用
    public void addLast(Node x){
        x.pre = tail.pre;
        x.next = tail;
        // 尾部的前一个节点的下一个节点重新设置为x
        tail.pre.next = x;
        // 尾部的前一个节点设置为x
        tail.pre = x;
        size++;
    }

    // 删除节点
    public void remove(Node x){
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    // 删除头部，头部表示最少使用并返回头节点
    public Node removeHead(){
        if(head.next == tail) {
            return null; // 说明是空链表
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int getSize(){
        return size;
    }
}

class Node{
    int key, value;
    Node pre,next;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
