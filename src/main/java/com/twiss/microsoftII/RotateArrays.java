package com.twiss.microsoftII;

/**
 * 旋转数组
 * 二分法查找
 * 时间复杂度O(nlogN)
 * @Author: Twiss
 * @Date: 2022/3/7 5:23 下午
 */
public class RotateArrays {

    public int search(int[] nums,int target){
        if (nums==null||nums.length==0){
            return -1;
        }
        if(nums.length==1){
            return target==nums[0]?0:-1;
        }
        int n = nums.length;
        int left = 0, right = n-1;
        while (left<=right){
            int mid = (right+left)>>1;
            if (target==nums[mid]){
                return mid;
            }
            if (nums[0]<nums[mid]){
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if (nums[mid]<=target&&target<=nums[right]){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        int ans = new RotateArrays().search(nums,target);
        System.out.println(ans);
    }
}
