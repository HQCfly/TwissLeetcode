package com.twiss.microsoft;


import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/12/26 10:56 下午
 */
public class ReverseLinkedList {

    public LinkedNode reverseNode(LinkedNode linkedNode){
        LinkedNode pre = null;
        LinkedNode current = linkedNode;
        LinkedNode tmp = null;
        while (current!=null){
            // 保留当前节点的下一个节点
            tmp = current.next;
            // 将当前节点的下一个节点替换成pre
            current.next = pre;
            // 将current，pre往后移动一位
            pre = current;
            current = tmp;
        }
        return pre;
    }

    public LinkedNode reverseListByRecursion(LinkedNode linkedNode){
        if (linkedNode==null||linkedNode.next==null){
            return linkedNode;
        }
        LinkedNode cur = reverseListByRecursion(linkedNode.next);
        linkedNode.next.next = linkedNode;
        linkedNode.next = null;
        return cur;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(10,new LinkedNode(20,new LinkedNode(30)));
        LinkedNode res = new ReverseLinkedList().reverseNode(linkedNode);
        System.out.println(JSONObject.toJSONString(res.val));

        LinkedNode linkedNode2 = new LinkedNode(10,new LinkedNode(20,new LinkedNode(30)));
        LinkedNode res2 = new ReverseLinkedList().reverseListByRecursion(linkedNode2);
        System.out.println(JSONObject.toJSONString(res2.val));

    }
}
