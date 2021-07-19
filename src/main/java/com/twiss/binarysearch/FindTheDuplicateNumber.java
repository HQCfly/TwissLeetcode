package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/19 5:20 下午
 */
public class FindTheDuplicateNumber {

    private int getDuplicateNumber(int[] nums){
        int low = 0, high = nums.length-1;
        while (low<high){
            int count = 0;
            int mid = low+(high-low)/2;
            for (int num:nums){
                if (num<=mid){
                    count++;
                }
            }
            if (count>mid){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 5, 2, 3, 1, 6, 7};
        int res = new FindTheDuplicateNumber().getDuplicateNumber(nums);
        System.out.println(res);
    }
}
