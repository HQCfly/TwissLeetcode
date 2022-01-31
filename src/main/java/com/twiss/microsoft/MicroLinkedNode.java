package com.twiss.microsoft;

/**
 * @Author: Twiss
 * @Date: 2022/1/31 3:42 下午
 */
public class MicroLinkedNode {
    int val;
    MicroLinkedNode next;
    MicroLinkedNode random;

    public MicroLinkedNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
