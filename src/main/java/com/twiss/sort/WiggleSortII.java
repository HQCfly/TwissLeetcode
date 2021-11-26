package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/11/22 11:01 下午
 */
public class WiggleSortII {

    public void getWiggleSort(int[] nums) {
        int[]bucket=new int[5001];
        for(int num:nums)bucket[num]++;
        int len=nums.length;
        int small,big;//穿插数字时的上界
        //总长度为奇数时，“小 大 小 大 小”边界左右都为较小的数；
        //总长度为偶数时，“小 大 小 大”边界左为较小的数，边界右为较大的数
        if((len&1)==1){
            small=len-1;
            big=len-2;
        }else{
            small=len-2;
            big=len-1;
        }
        int j=5000; //从后往前，将桶中数字穿插到数组中，后界为j
        //桶中大的数字在后面，小的数字在前面，所以先取出较大的数字，再取出较小的数字
        //先将桶中的较大的数字穿插放在nums中
        for(int i=1;i<=big;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
        //再将桶中的较小的数字穿插放在nums中
        for(int i=0;i<=small;i+=2){
            while (bucket[j]==0)j--;//找到不为0的桶
            nums[i]=j;
            bucket[j]--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 1, 1, 6, 4};
        new WiggleSortII().getWiggleSort(numbers);
        System.out.println(JSONObject.toJSONString(numbers));
    }
}
