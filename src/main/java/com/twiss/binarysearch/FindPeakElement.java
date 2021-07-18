package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/18 9:02 下午
 */
public class FindPeakElement {

    private int getPeakElement(int[] nums){
        int low = 0, high = nums.length-1;
        while (low<high){
            int mid = low+(high-low)/2;
            if (nums[mid]>nums[mid+1]){
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int peakNum = new FindPeakElement().getPeakElement(nums);
        System.out.println(peakNum);
    }
}
