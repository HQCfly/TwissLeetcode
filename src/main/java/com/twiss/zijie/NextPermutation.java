package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

/**
 * 下一个排列
 * 双遍历法
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/14 10:04 下午
 */
public class NextPermutation {

    public int[] getNextPermutation(int[] nums){
        if (nums==null||nums.length==0){
            return nums;
        }
        int n = nums.length;
        // 第一遍遍历找出i，即从后往前数第一个nums[i]<nums[i+1]的下标
        int i = n-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if (i>=0){
            int j = n-1;
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            // 交换i和j的元素
            swap(nums,i,j);
        }
        // 将第i+1以后的元素进行翻转即可得到最近的最大数
        reverse(nums,i+1);
        return nums;
    }

    private void swap(int[] nums, int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    private void reverse(int[] nums, int start){
        int left = start; int right = nums.length-1;
        while (left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] ans = new NextPermutation().getNextPermutation(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
