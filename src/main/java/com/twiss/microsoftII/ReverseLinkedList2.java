package com.twiss.microsoftII;

/**
 * 反转链表
 * @Author: Twiss
 * @Date: 2022/3/2 12:57 下午
 */
public class ReverseLinkedList2 {

    public ListNode getReverseList(ListNode listNode){
        if (listNode==null){
            return null;
        }
        ListNode previous = null, tmp = null;
        ListNode curr = listNode;
        while (curr!=null){
            tmp = curr.next;
            curr.next = previous;
            previous = curr;
            curr = tmp;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode res = new ReverseLinkedList2().getReverseList(listNode);
        System.out.println(res.val);
    }
}
