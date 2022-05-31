package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 删除链表的倒数第N个节点
 * @Author: Twiss
 * @Date: 2022/5/31 10:14 下午
 */
public class RemoveNthFromEnd {

    public LinkedNode getNewList(LinkedNode head,int n){
        LinkedNode dummy = new LinkedNode(-1, head);
        LinkedNode fast = dummy;
        LinkedNode slow = dummy;
        while (n-->0){
            fast = fast.next;
        }

        // 保存删除slow的上一个节点
        LinkedNode pre = null;
        while (fast!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);
        head.next.next.next.next = new LinkedNode(5);
        LinkedNode ans = new RemoveNthFromEnd().getNewList(head,2);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
