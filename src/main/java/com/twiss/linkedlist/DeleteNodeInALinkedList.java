package com.twiss.linkedlist;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 12:59 下午
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(LinkedNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 2->4->3
     * @param args
     */
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(2);
        LinkedNode node12 = new LinkedNode(4);
        LinkedNode node13 = new LinkedNode(3);
        node1.next = node12;
        node12.next = node13;
        new DeleteNodeInALinkedList().deleteNode(node12);
        System.out.println(JSONObject.toJSONString(node1));
    }
}
