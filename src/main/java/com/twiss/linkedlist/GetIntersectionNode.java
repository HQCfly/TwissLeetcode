package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 链表相交
 * @Author: Twiss
 * @Date: 2022/5/31 10:32 下午
 */
public class GetIntersectionNode {

    public LinkedNode getIntersection(LinkedNode headA,LinkedNode headB){
        LinkedNode currA = headA;
        LinkedNode currB = headB;
        int lenA = 0, lenB = 0;
        while (currA!=null){
            lenA++;
            currA = currA.next;
        }

        while (currB!=null){
            lenB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;
        if (lenB>lenA){
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            LinkedNode tmp  =currA;
            currA = currB;
            currB = tmp;
        }

        int gap = lenA-lenB;
        while (gap-->0){
            currA = currA.next;
        }
        while (currA!=null){
            if (currA==currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
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
