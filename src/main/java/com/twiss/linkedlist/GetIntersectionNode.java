package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 链表相交
 * @Author: Twiss
 * @Date: 2022/5/31 10:32 下午
 */
public class GetIntersectionNode {

    public LinkedNode getIntersection(LinkedNode headA,LinkedNode headB){
        LinkedNode curA = headA;
        LinkedNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            LinkedNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedNode headA = new LinkedNode(3);
        headA.next = new LinkedNode(9);
        headA.next.next = new LinkedNode(8);
        headA.next.next.next = new LinkedNode(7);
        headA.next.next.next.next = new LinkedNode(6);
        headA.next.next.next.next.next = new LinkedNode(5);
        headA.next.next.next.next.next.next = new LinkedNode(4);
        headA.next.next.next.next.next.next.next = new LinkedNode(2);

        LinkedNode headB = new LinkedNode(11);
        headB.next = new LinkedNode(5);
        headB.next.next = new LinkedNode(4);
        headB.next.next.next = new LinkedNode(2);

        LinkedNode ans = new GetIntersectionNode().getIntersection(headA,headB);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
