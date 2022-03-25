package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 * @Author: Twiss
 * @Date: 2022/3/25 3:51 下午
 */
public class QuickSorted5 {

    public int[] getQuick(int[] nums){
        if (nums==null||nums.length==0){
            return nums;
        }
        randomQuickSorted(nums,0,nums.length-1);
        return nums;
    }

    private void randomQuickSorted(int[] nums, int left,int right){
        if (left<right){
            int index = randomPartition(nums,left,right);
            randomQuickSorted(nums,left,index-1);
            randomQuickSorted(nums,index+1,right);
        }
    }

    private int randomPartition(int[] nums, int left, int right){
        int pivotIndex = left+new Random().nextInt(right-left+1);
        swap(nums,pivotIndex,right);
        int pivot = nums[right];
        int l = left-1;
        for (int i=left;i<right;++i){
            if (nums[i]<=pivot){
                l += 1;
                swap(nums,l,i);
            }
        }
        swap(nums,l+1,right);
        return l+1;
    }

    private void swap(int[] nums,int index1,int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,1,5};
        int[] ans = new QuickSorted5().getQuick(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
