package com.twiss.linkedlist;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 12:03 下午
 */
public class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode() {

    }

    public LinkedNode(int x) {
        this.val = x;
    }

    public LinkedNode(int x, LinkedNode next) {
        this.val = x;
        this.next = next;
    }
}
