package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/9/1 12:03 下午
 */
public class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode() {

    }

    public LinkedNode(int x) {
        this.val = x;
    }

    public LinkedNode(int x, LinkedNode next) {
        this.val = x;
        this.next = next;
    }

    /**
     * 50->40->30
     * @param args
     */
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(50);
        LinkedNode node12 = new LinkedNode(40);
        LinkedNode node13 = new LinkedNode(30);
        node1.next = node12;
        node12.next = node13;
        System.out.println(JSONObject.toJSONString(node1));
    }
}
