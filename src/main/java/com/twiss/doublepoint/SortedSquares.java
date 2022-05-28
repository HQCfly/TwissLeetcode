package com.twiss.doublepoint;

import com.alibaba.fastjson.JSONObject;

/**
 * 有效数组的平方
 * @Author: Twiss
 * @Date: 2022/5/28 12:25 下午
 */
public class SortedSquares {

    public int[] getSquare(int[] nums){
        if (nums==null||nums.length==0){
            return null;
        }
        int n = nums.length;
        int negative = -1;
        for (int i=0;i<n;i++){
            if (nums[i]<0){
                negative = i;
            } else {
                break;
            }
        }
        int[] ans = new int[n];
        // index表示顺序替换下标，i表示负数的那一部分，j表示正数的那一部分
        int index = 0, i = negative, j = negative+1;
        while (i>=0||j<n){
            // 表示负数部分已经全部排序好
            if (i<0){
                ans[index] = nums[j]*nums[j];
                j++;
            }else if (j==n){
                ans[index] = nums[i]*nums[i];
                i--;
            }else if (nums[i]*nums[i]<nums[j]*nums[j]){
                ans[index] = nums[i]*nums[i];
                i--;
            }else {
                ans[index] = nums[j]*nums[j];
                j++;
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] ans = new SortedSquares().getSquare(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
