package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * 时间复杂度O(nlogn)
 * 空间复杂度O(logn)
 * @Author: Twiss
 * @Date: 2022/3/12 10:48 下午
 */
public class QuickSorted4 {

    public int[] getSorted(int[] nums){
        if (nums==null||nums.length==0){
            return nums;
        }
        randomPartition(nums,0,nums.length-1);
        return nums;
    }

    private void randomPartition(int[] nums, int left,int right){
        if(left<right){
            int index = partition(nums,left,right);
            partition(nums,left,index-1);
            partition(nums,index+1,right);
        }
    }

    private int partition(int[] nums, int left,int right){
        int partitionIndex = left+ new Random().nextInt(right-left+1);
        swap(nums,partitionIndex,right);
        int pivot = nums[right];
        int i = left-1;
        for (int j=left;j<right;++j){
            if (nums[j]<=pivot){
                i = i+1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,right);
        return i+1;
    }

    private void swap(int[] nums, int index1, int index2){
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,1,5};
        int[] ans = new QuickSorted4().getSorted(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
