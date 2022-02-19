package com.twiss.microsoftII;

/**
 * 链表
 *
 * @Author: Twiss
 * @Date: 2022/2/19 1:24 下午
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
