package com.twiss.autodrive;

/**
 * 删除倒数第N个节点
 * @Author: Twiss
 * @Date: 2022/9/12 5:25 下午
 */
public class DeleteNthNode {

    public ListNode remove(ListNode node,int n){
        ListNode ans = node;
        if (node==null){
            return ans;
        }
        int size = 0;
        ListNode tmpNode = node;
        while (tmpNode.next!=null){
            tmpNode = tmpNode.next;
            size++;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
