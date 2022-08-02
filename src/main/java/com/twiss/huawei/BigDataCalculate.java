package com.twiss.huawei;

/**
 * 给出两个链表用来表示两个非负的整数(范围未知)。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个链表来表示它们的和。
 * 大数计算
 * 请实现功能并给出至少三组测试用例（示例不算）
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @Author: Twiss
 * @Date: 2022/8/2 10:06 上午
 */
public class BigDataCalculate {

    public ListNodeHw getSumOfList(ListNodeHw list1,ListNodeHw list2){
        ListNodeHw ans = new ListNodeHw();
        if (list1==null&&list2==null){
            return ans;
        }
        Integer num1 = getReverseNum(list1);
        Integer num2 = getReverseNum(list2);
        Integer sum = num1+num2;
        String tmp = String.valueOf(sum);
        int n = tmp.length()-1;
        char[] tmpArr = tmp.toCharArray();
        backtracing(ans,tmpArr,n,Integer.parseInt(String.valueOf(tmpArr[n-1])));
        return ans;
    }

    private ListNodeHw backtracing(ListNodeHw list, char[] tmp, int cur,int val){
        if (cur<0){
            return null;
        }
        list.val = val;
        return list.next = backtracing(list,tmp,cur,Integer.parseInt(String.valueOf(tmp[cur])));
    }

    private Integer getReverseNum(ListNodeHw list){
        StringBuilder stringBuilder = new StringBuilder();
        while (list!=null){
            stringBuilder.append(list.val);
            list = list.next;
        }
        stringBuilder.reverse();
        return Integer.parseInt(new String(stringBuilder));
    }

    public static void main(String[] args) {
        ListNodeHw list1 = new ListNodeHw(2);
        list1.next = new ListNodeHw(4);
        list1.next.next = new ListNodeHw(0);

        ListNodeHw list2 = new ListNodeHw(5);
        list2.next = new ListNodeHw(6);
        list2.next.next = new ListNodeHw(4);

        ListNodeHw ans = new BigDataCalculate().getSumOfList(list1,list2);
        System.out.println(ans.val);

    }

}
class ListNodeHw{
    Integer val;
    ListNodeHw next;
    public ListNodeHw(){

    }
    public ListNodeHw(Integer val){
        this.val = val;
    }
    public ListNodeHw(Integer val,ListNodeHw next){
        this.val = val;
        this.next = next;
    }
}