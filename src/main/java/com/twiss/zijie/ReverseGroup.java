package com.twiss.zijie;

/**
 * 翻转k组链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/k-ge-yi-zu-fan-zhuan-lian-biao-by-leetcode-solutio/
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/1 9:45 下午
 */
public class ReverseGroup {

    public ZJLinkedNode getReverse(ZJLinkedNode head, int k){
        ZJLinkedNode hair = new ZJLinkedNode(0);
        hair.next = head;
        ZJLinkedNode pre = hair;
        while (head!=null){
            // 确定当前翻转的tail节点
            ZJLinkedNode tail = pre;
            for (int i=0;i<k;++i){
                tail = tail.next;
                if (tail==null){
                    return hair.next;
                }
            }
            ZJLinkedNode tmp = tail.next;
            // 翻转head和tail  k范围内的节点
            ZJLinkedNode[] reverse = reverse(head,tail);
            head = reverse[0];
            tail = reverse[1];
            // 将其重新链接到前后节点中
            // 将之前的pre的下一个节点链接为head，保持当次翻转后的顺序
            pre.next = head;
            // 将当前的尾部下一节点换成tmp，重新链接tail的后续节点
            tail.next = tmp;
            // 将pre重新替换成下一轮的tail
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ZJLinkedNode[] reverse(ZJLinkedNode head, ZJLinkedNode tail){
        ZJLinkedNode pre = tail.next;
        ZJLinkedNode curr = head;
        ZJLinkedNode tmp = null;
        while (pre!=tail){
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return new ZJLinkedNode[]{tail,head};
    }

    public static void main(String[] args) {
        ZJLinkedNode head = new ZJLinkedNode(1);
        head.next = new ZJLinkedNode(2);
        head.next.next = new ZJLinkedNode(3);
        head.next.next.next = new ZJLinkedNode(4);
        head.next.next.next.next = new ZJLinkedNode(5);
        int k = 2;
        ZJLinkedNode ans = new ReverseGroup().getReverse(head,k);
        System.out.println(ans.val);
    }
}
