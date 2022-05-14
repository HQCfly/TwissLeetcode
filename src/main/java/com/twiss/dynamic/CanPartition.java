package com.twiss.dynamic;

/**
 * 分割等和子集
 * @Author: Twiss
 * @Date: 2022/5/14 12:13 下午
 */
public class CanPartition {

    public boolean couldPartition(int[] nums){
        if (nums==null||nums.length==0){
            return false;
        }
        int n = nums.length;
        int sum = 0;
        for (int num: nums){
            sum+=num;
        }
        if (sum%2!=0){
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target+1];
        for (int i=0;i<n;i++){
            for (int j=target;j>=nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean ans = new CanPartition().couldPartition(nums);
        System.out.println(ans);
    }
}
