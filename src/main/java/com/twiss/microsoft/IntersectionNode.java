package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2022/2/12 8:08 下午
 */
public class IntersectionNode {

    public LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        LinkedNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public LinkedNode getIntersectionNodeByHash(LinkedNode headA, LinkedNode headB){
        Set<LinkedNode> visited = new HashSet<LinkedNode>();
        LinkedNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedNode nodeA = new LinkedNode(4);
        nodeA.next = new LinkedNode(1);
        nodeA.next.next = new LinkedNode(8);
        nodeA.next.next.next = new LinkedNode(4);
        nodeA.next.next.next.next = new LinkedNode(5);

        LinkedNode nodeB = new LinkedNode(5);
        nodeB.next = new LinkedNode(6);
        nodeB.next.next = new LinkedNode(1);
        nodeB.next.next.next = new LinkedNode(8);
        nodeB.next.next.next.next = new LinkedNode(4);
        nodeB.next.next.next.next.next = new LinkedNode(5);

//        LinkedNode res = new IntersectionNode().getIntersectionNode(nodeA,nodeB);
//        System.out.println(res);

        LinkedNode res2 = new IntersectionNode().getIntersectionNodeByHash(nodeA,nodeB);
        System.out.println(JSONObject.toJSONString(res2));

    }
}
