package com.twiss.heaps;

import com.alibaba.fastjson.JSONObject;
import com.twiss.linkedlist.LinkedNode;

/**
 * @Author: Twiss
 * @Date: 2021/9/10 11:21 下午
 */
public class MergeKLists {

    public LinkedNode mergeLinkedNode(LinkedNode[] lists) {
        LinkedNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    private LinkedNode mergeTwoLists(LinkedNode a, LinkedNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        LinkedNode head = new LinkedNode(0);
        LinkedNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public LinkedNode mergeKListByMergeSort(LinkedNode[] lists){
        return merge(lists,0,lists.length-1);
    }

    public LinkedNode merge(LinkedNode[] lists,int l,int r){
        if (l==r){
            return lists[l];
        }
        if (l>r){
            return null;
        }

        int mid = (l+r)>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    public static void main(String[] args) {
        // 1,4,5
        LinkedNode node1 = new LinkedNode(1,new LinkedNode(4,new LinkedNode(5)));
        // 1,3,4
        LinkedNode node2 = new LinkedNode(1,new LinkedNode(3,new LinkedNode(4)));
        // 2,6
        LinkedNode node3 = new LinkedNode(2,new LinkedNode(6));

        LinkedNode[] list = {node1,node2,node3};

//        LinkedNode res = new MergeKLists().mergeLinkedNode(list);
//        System.out.println(JSONObject.toJSONString(res));


        LinkedNode[] list2 = {node1,node2,node3};
        LinkedNode res2 = new MergeKLists().mergeKListByMergeSort(list2);
        System.out.println(JSONObject.toJSONString(res2));

    }
}
