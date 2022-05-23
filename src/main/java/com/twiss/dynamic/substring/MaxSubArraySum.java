package com.twiss.dynamic.substring;

/**
 * 最大子序和
 * dp[i] = Max(dp[i-1]+num[i],num[i])
 * res = Max(dp[i],res)
 * @Author: Twiss
 * @Date: 2022/5/23 11:34 上午
 */
public class MaxSubArraySum {

    public int getMaxSum(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res=  0;
        for (int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int getMaxSumByGreed(int[] nums){
        int count = 0, res = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            count+=nums[i];
            res = Math.max(res,count);
            if (count<0){
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int ans = new MaxSubArraySum().getMaxSum(nums);
        System.out.println(ans);

        int ans2 = new MaxSubArraySum().getMaxSumByGreed(nums);
        System.out.println(ans2);
    }
}
