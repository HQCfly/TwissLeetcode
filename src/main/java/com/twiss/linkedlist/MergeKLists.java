package com.twiss.linkedlist;

/**
 * @Author: Twiss
 * @Date: 2021/9/10 11:21 下午
 */
public class MergeKLists {

    public LinkedNode mergeLinkedNode(LinkedNode[] lists) {
        LinkedNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = merge(ans, lists[i]);
        }
        return ans;
    }

    private LinkedNode merge(LinkedNode linkedNodeA, LinkedNode linkedNodeB) {
        if (linkedNodeA == null || linkedNodeB == null) {
            return linkedNodeA == null ? linkedNodeB : linkedNodeA;
        }

        LinkedNode head = new LinkedNode(0);
        LinkedNode tail = head, aPtr = linkedNodeA, bPtr = linkedNodeB;
        while (aPtr != null || bPtr != null) {
            if (aPtr.val > bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void main(String[] args) {

    }
}
