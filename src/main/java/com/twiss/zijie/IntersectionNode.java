package com.twiss.zijie;

import java.util.HashSet;
import java.util.Set;

/**
 * 相交链表
 * 双指针：
 * 时间复杂度O(m+n)
 * 时间复杂度O(1)
 * 哈希表
 * 时间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/4/3 8:19 下午
 */
public class IntersectionNode {

    public ZJLinkedNode getIntersection(ZJLinkedNode headA,ZJLinkedNode headB){
        if (headA == null || headB == null) {
            return null;
        }
        ZJLinkedNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ZJLinkedNode getNodeByHash(ZJLinkedNode head1,ZJLinkedNode head2){
        if (head1==null||head2==null){
            return null;
        }
        Set<ZJLinkedNode> visited = new HashSet<>();
        ZJLinkedNode tmp = head1;
        while (tmp!=null){
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = head2;
        while (tmp!=null){
            if (visited.contains(tmp)){
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ZJLinkedNode head1 = new ZJLinkedNode(4);
        head1.next = new ZJLinkedNode(1);
        head1.next.next = new ZJLinkedNode(8);
        head1.next.next.next = new ZJLinkedNode(4);
        head1.next.next.next.next = new ZJLinkedNode(5);

        ZJLinkedNode head2 = new ZJLinkedNode(5);
        head2.next = new ZJLinkedNode(6);
        head2.next.next = new ZJLinkedNode(1);
        head2.next.next.next = new ZJLinkedNode(8);
        head2.next.next.next.next = new ZJLinkedNode(4);
        head2.next.next.next.next.next = new ZJLinkedNode(5);

        ZJLinkedNode ans = new IntersectionNode().getIntersection(head1,head2);
        System.out.println(ans.val);

//        ZJLinkedNode ans2 = new IntersectionNode().getNodeByHash(head1,head2);
//        System.out.println(ans2.val);
    }

}
