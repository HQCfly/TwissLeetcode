package com.twiss.doublepoint;

/**
 * 删除排序数组中的重复元素
 * @Author: Twiss
 * @Date: 2022/5/27 2:32 下午
 */
public class RemoveDuplicates {

    public int getNewArray(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int fast=1, slow = 1;
        while (fast<nums.length){
            if (nums[fast]!=nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,2,2,3,3,4};
        int ans = new RemoveDuplicates().getNewArray(nums);
        System.out.println(ans);
    }
}
