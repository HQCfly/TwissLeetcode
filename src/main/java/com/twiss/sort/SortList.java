package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/11/17 11:40 下午
 */
public class SortList {

    public ListNode getSortedList(ListNode head){
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail){
        if (head == null) {
            return head;
        }
        if (head.next==tail){
            head.next=null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast!=tail){
            slow = slow.next;
            fast = fast.next;
            if (fast!=tail){
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        ListNode list1 = sortList(head,mid);
        ListNode list2 = sortList(mid,tail);
        ListNode sorted = merge(list1,list2);
        return sorted;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        ListNode res = new SortList().getSortedList(head);
        System.out.println(res.val);
    }
}
