package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * 移除链表元素
 * @Author: Twiss
 * @Date: 2022/5/30 4:45 下午
 */
public class RemoveElements {

    public LinkedNode getNewLinked(LinkedNode head,int val){
        if (head==null){
            return null;
        }

        LinkedNode dummy = new LinkedNode(-1,head);
        LinkedNode pre = dummy;
        LinkedNode curr = head;
        while (curr!=null){
            if (curr.val==val){
                pre.next = curr.next;
            }else {
                pre = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(2);
        LinkedNode node12 = new LinkedNode(4);
        node12.next = new LinkedNode(5);
        node1.next = node12;
        new RemoveElements().getNewLinked(node1,4);
        System.out.println(JSONObject.toJSONString(node1));
    }
}
