package com.twiss.zijie;

/**
 * 链表
 *
 * @Author: Twiss
 * @Date: 2022/3/30 5:05 下午
 */
public class ZJLinkedNode {
    int val;
    ZJLinkedNode next;

    ZJLinkedNode() {

    }

    ZJLinkedNode(int val) {
        this.val = val;
    }

    ZJLinkedNode(int val, ZJLinkedNode next) {
        this.val = val;
        this.next = next;
    }
}
