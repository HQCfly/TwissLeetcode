package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 环形链表II
 * @Author: Twiss
 * @Date: 2022/6/1 11:52 下午
 */
public class DetectCycle {

    public LinkedNode getCyclePoint(LinkedNode head){
        LinkedNode slow = head;
        LinkedNode fast = head;
        while (fast!=null&&slow!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast==slow){
                LinkedNode index1 = fast;
                LinkedNode index2 = head;
                while (index1!=index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedNode head = new LinkedNode(3);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(0);
        head.next.next.next = new LinkedNode(-4);
        head.next.next.next.next = head.next;
        LinkedNode ans = new DetectCycle().getCyclePoint(head);
        System.out.println(ans.val);
    }

}
