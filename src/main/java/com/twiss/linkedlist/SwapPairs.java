package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 两两交换链表中的节点
 * @Author: Twiss
 * @Date: 2022/5/30 7:22 下午
 */
public class SwapPairs {

    public LinkedNode getNewLinkedList(LinkedNode head){
        LinkedNode dummy = new LinkedNode(0,head);
        LinkedNode pre = dummy;
        while (pre.next!=null&&pre.next.next!=null){
            LinkedNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = head.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next= new LinkedNode(3);
        head.next.next.next= new LinkedNode(4);
        LinkedNode ans = new SwapPairs().getNewLinkedList(head);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
