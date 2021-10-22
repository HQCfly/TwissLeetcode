package com.twiss.sort;

/**
 * @Author: Twiss
 * @Date: 2021/10/19 11:22 下午
 */
public class InsertionSortList {

    public ListNode insertSort(ListNode node) {
        if(node==null){
            return node;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = node;
        ListNode lastSorted = dummyHead, curr = node.next;
        while (curr!=null){
            if (lastSorted.val<=curr.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummyHead;
                while (pre.next.val<=curr.val){
                    pre = pre.next;
                }
                lastSorted.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead;
    }

    public static void main(String[] args) {

    }

}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
