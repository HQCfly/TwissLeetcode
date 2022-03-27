package com.twiss.microsoftII;

import com.twiss.microsoft.LinkedNode;

import java.util.HashSet;

/**
 * 判断是否是换型链表
 * 快慢指针法
 * 时间复杂度
 * 空间复杂度
 * @Author: Twiss
 * @Date: 2022/3/27 8:46 下午
 */
public class CycleLinkedList {

    public boolean hasCycle(LinkedNode linkedNode){
        if (linkedNode==null){
            return false;
        }

        LinkedNode slow = linkedNode;
        LinkedNode fast = linkedNode.next;
        while (fast!=slow){
            if (fast==null||fast.next==null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean hasCycleByHashMap(LinkedNode linkedNode){
        HashSet<LinkedNode> hashSet = new HashSet<>();
        while (linkedNode!=null){
            if (!hashSet.add(linkedNode)){
                return true;
            }
            linkedNode = linkedNode.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(3);
        linkedNode.next = new LinkedNode(2);
        linkedNode.next.next = new LinkedNode(0);
        linkedNode.next.next.next = new LinkedNode(-4);
        linkedNode.next.next.next.next = new LinkedNode(2);
        boolean ans1 = new CycleLinkedList().hasCycle(linkedNode);
        System.out.println(ans1);
        boolean ans2 = new CycleLinkedList().hasCycleByHashMap(linkedNode);
        System.out.println(ans2);
    }
}
