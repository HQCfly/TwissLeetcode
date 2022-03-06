package com.twiss.microsoftII;

import com.twiss.microsoft.LinkedNode;

/**
 * 反转链表
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/3/6 4:16 下午
 */
public class ReverseLinkedList3 {

    public LinkedNode getReverse(LinkedNode linkedNode){
        if (linkedNode==null){
            return null;
        }
        LinkedNode previous = null, tmp = null;
        LinkedNode curr = linkedNode;
        while (curr!=null){
            tmp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = tmp;
        }
        return previous;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(1);
        linkedNode.next = new LinkedNode(2);
        linkedNode.next.next = new LinkedNode(3);
        LinkedNode ans = new ReverseLinkedList3().getReverse(linkedNode);
        System.out.println(ans.val);
    }
}
