package com.twiss.linkedlist;

/**
 * @Author: Twiss
 * @Date: 2021/12/2 4:09 下午
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class MiddleNode {

    public LinkedNode getMiddleNode(LinkedNode head) {
        LinkedNode[] A = new LinkedNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

}
