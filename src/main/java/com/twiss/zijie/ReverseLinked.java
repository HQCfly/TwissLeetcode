package com.twiss.zijie;

/**
 * 反转链表
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/3/30 4:57 下午
 */
public class ReverseLinked {

    public ZJLinkedNode getReverseLinked(ZJLinkedNode head){
        if (head==null){
            return null;
        }
        ZJLinkedNode pre = null, tmp = null;
        ZJLinkedNode curr = head;
        while (curr!=null){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ZJLinkedNode linkedNode = new ZJLinkedNode(1);
        linkedNode.next = new ZJLinkedNode(2);
        linkedNode.next.next = new ZJLinkedNode(3);
        linkedNode.next.next.next = new ZJLinkedNode(4);
        ZJLinkedNode ans = new ReverseLinked().getReverseLinked(linkedNode);
        System.out.println(ans.val);
    }
}
