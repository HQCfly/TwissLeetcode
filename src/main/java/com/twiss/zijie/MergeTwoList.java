package com.twiss.zijie;

/**
 * 合并两个链表
 * 时间复杂度O(m+n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/11 7:21 下午
 */
public class MergeTwoList {

    public ZJLinkedNode mergeList(ZJLinkedNode list1,ZJLinkedNode list2){
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }else if (list1.val< list2.val){
            list1.next = mergeList(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeList(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ZJLinkedNode list1 = new ZJLinkedNode(1);
        list1.next = new ZJLinkedNode(2);
        list1.next.next = new ZJLinkedNode(4);

        ZJLinkedNode list2 = new ZJLinkedNode(1);
        list2.next = new ZJLinkedNode(3);
        list2.next.next = new ZJLinkedNode(4);

        ZJLinkedNode ans = new MergeTwoList().mergeList(list1,list2);
        System.out.println(ans.next.val);
    }
}
