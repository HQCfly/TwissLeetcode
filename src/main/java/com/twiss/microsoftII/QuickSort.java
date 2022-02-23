package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
 * @Author: Twiss
 * @Date: 2022/2/23 4:32 下午
 */
public class QuickSort {

    public int[] getSortedNums(int[] nums){
        if (nums==null){
            return null;
        }
        quick(nums,0,nums.length-1);
        return nums;
    }

    private void quick(int[] nums, int left, int right){
        if (left<right){
            int pos = partition(nums,left,right);
            quick(nums,left,pos-1);
            quick(nums,pos+1,right);
        }
    }

    private int partition(int[] nums,int left, int right){
        int randomIndex = new Random().nextInt(right-left+1)+1;
        swap(nums,randomIndex,right);
        int pivot = nums[right];
        int lt = left-1;
        for (int i=1;i<right;++i){
            if (nums[i]<=pivot){
                lt++;
                swap(nums,lt,i);
            }
        }
        swap(nums,lt+1,right);
        return lt+1;
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] res = new QuickSort().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(res));
    }
}
