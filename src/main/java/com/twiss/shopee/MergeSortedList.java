package com.twiss.shopee;


/**
 * 递归或者迭代法
 * 时间复杂度O(m+n)
 * 空间复杂度O(m+n)
 * @Author: Twiss
 * @Date: 2022/3/22 9:02 下午
 */
public class MergeSortedList {

    public ListNodeSp getMerge(ListNodeSp list1, ListNodeSp list2){
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }else if (list1.val<list2.val){
            list1.next = getMerge(list1.next,list2);
            return list1;
        }else {
            list2.next = getMerge(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNodeSp listNodeSp1 = new ListNodeSp(1);
        listNodeSp1.next = new ListNodeSp(4);
        listNodeSp1.next.next = new ListNodeSp(5);

        ListNodeSp listNodeSp2 = new ListNodeSp(1);
        listNodeSp2.next = new ListNodeSp(2);
        listNodeSp2.next.next = new ListNodeSp(3);
        listNodeSp2.next.next.next = new ListNodeSp(6);

        ListNodeSp ans = new MergeSortedList().getMerge(listNodeSp1,listNodeSp2);
        System.out.println(ans.next.next.val);
    }
}
