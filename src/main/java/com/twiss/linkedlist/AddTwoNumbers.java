package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 12:03 下午
 */
public class AddTwoNumbers {

    public LinkedNode getResult(LinkedNode linkedNode1, LinkedNode linkedNode2) {
        // 建立一个0为head 的链表
        LinkedNode res = new LinkedNode(0);
        LinkedNode p = res;

        int c = 0;
        while (linkedNode1 != null || linkedNode2 != null || c != 0) {
            int ln1 = (linkedNode1==null)?0:linkedNode1.val;
            int ln2 = (linkedNode2==null)?0:linkedNode2.val;

            int sum = ln1+ln2+c;

            int singleOfSum = sum%10;

            p.next = new LinkedNode(singleOfSum);

            p = p.next;

            if (linkedNode1!=null) {
                linkedNode1 = linkedNode1.next;
            }
            if (linkedNode2!=null){
                linkedNode2 = linkedNode2.next;
            }
            // 看pre的sum是否需要进位
            c = sum/10;

        }
        return res.next;
    }

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(2);
        LinkedNode node12 = new LinkedNode(4);
        LinkedNode node13 = new LinkedNode(3);
        node1.next = node12;
        node12.next = node13;

        LinkedNode node2 = new LinkedNode(5);
        LinkedNode node22 = new LinkedNode(6);
        LinkedNode node23 = new LinkedNode(4);
        node2.next = node22;
        node22.next = node23;

        LinkedNode res = new AddTwoNumbers().getResult(node1,node2);
        System.out.println(JSONObject.toJSONString(res));
    }
}
