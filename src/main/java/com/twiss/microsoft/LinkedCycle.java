package com.twiss.microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2022/1/14 11:19 下午
 */
public class LinkedCycle {

    public boolean hasCycle(LinkedNode head){
        Set<LinkedNode> set = new HashSet<>();
        while (head!=null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleByFastAndSlow(LinkedNode head){
        if (head==null||head.next==null){
            return false;
        }
        LinkedNode slow = head.next;
        LinkedNode fast = head.next.next;
        while (slow!=fast){
            if (fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1);
        node.next = new LinkedNode(2);
        node.next.next = node;
        boolean res = new LinkedCycle().hasCycle(node);
        System.out.println(res);

        boolean res2 = new LinkedCycle().hasCycleByFastAndSlow(node);
        System.out.println(res2);
    }
}
