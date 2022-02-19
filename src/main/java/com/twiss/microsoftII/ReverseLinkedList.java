package com.twiss.microsoftII;

/**
 * 反转链表
 * @Author: Twiss
 * @Date: 2022/2/19 1:24 下午
 */
public class ReverseLinkedList {

    public ListNode getReverseByIterator(ListNode listNode){
        if (listNode==null){
            return null;
        }
        ListNode tmp = null;
        ListNode previous = null;
        ListNode curr = listNode;
        while (curr!=null){
            tmp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = tmp;
        }
        return previous;
    }

    public ListNode getReverseByRecursion(ListNode listNode){
        if (listNode==null||listNode.next==null){
            return listNode;
        }
        ListNode cur = getReverseByIterator(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return cur;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode ans = new ReverseLinkedList().getReverseByIterator(listNode);
        System.out.println(ans.next.val);
    }
}
