package com.twiss.dynamic.substring;

import java.util.Arrays;

/**
 * 最长连续递增子序列长度
 *
 * @Author: Twiss
 * @Date: 2022/5/21 12:57 下午
 */
public class MaxLengthIncreaseContinue {

    public int getMaxLength(int[] nums){
        if (nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i=0;i<n-1;i++){
            if (nums[i+1]>nums[i]){
                dp[i+1] = dp[i]+1;
            }
            res =  Math.max(res,dp[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int ans = new MaxLengthIncreaseContinue().getMaxLength(nums);
        System.out.println(ans);
    }
}
