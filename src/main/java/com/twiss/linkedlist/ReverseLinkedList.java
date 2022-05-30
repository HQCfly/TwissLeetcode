package com.twiss.linkedlist;

/**
 * 翻转链表
 * @Author: Twiss
 * @Date: 2022/5/30 6:10 下午
 */
public class ReverseLinkedList {

    public LinkedNode getReverse(LinkedNode head){
        if (head==null){
            return null;
        }
        LinkedNode pre = null;
        LinkedNode curr = head;
        LinkedNode tmp;
        while (curr!=null){
           tmp = curr.next;
           curr.next = pre;
           pre = curr;
           curr = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);
        head.next.next.next.next = new LinkedNode(5);
        LinkedNode res = new ReverseLinkedList().getReverse(head);
        System.out.println(res);
    }
}
