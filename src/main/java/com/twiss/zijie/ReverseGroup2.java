package com.twiss.zijie;

/**
 * @Author: Twiss
 * @Date: 2022/4/2 8:03 下午
 */
public class ReverseGroup2 {

    private ZJLinkedNode getReverse(ZJLinkedNode head,int k){
        ZJLinkedNode hair = new ZJLinkedNode(0);
        hair.next = head;
        ZJLinkedNode pre = hair;
        while (head!=null){
            // 选择tail
            ZJLinkedNode tail = pre;
            for (int i=0;i<k;++i){
                tail = tail.next;
                if (tail==null){
                    return hair.next;
                }
            }
            // 临时存下tail的下一个节点，方便下一次循环做完头节点
            ZJLinkedNode tmp = tail.next;
            ZJLinkedNode[] reverseNode = reverse(head,tail);
            head = reverseNode[0];
            tail = reverseNode[1];

            // 修改当前节点
            pre.next = head;
            tail.next = tmp;
            // 进行下一轮
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ZJLinkedNode[] reverse(ZJLinkedNode head, ZJLinkedNode tail){
        ZJLinkedNode pre = tail.next;
        ZJLinkedNode tmp = null;
        ZJLinkedNode curr = head;
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
        int k =2;
        ZJLinkedNode ans = new ReverseGroup2().getReverse(head,k);
        System.out.println(ans.next.val);
    }
}
