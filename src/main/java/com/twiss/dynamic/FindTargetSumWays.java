package com.twiss.dynamic;

/**
 * 目标和
 * @Author: Twiss
 * @Date: 2022/5/14 2:07 下午
 */
public class FindTargetSumWays {

    public int getTargetSum(int[] nums,int target){
        if (nums==null||nums.length==0){
            return 0;
        }
        int n = nums.length;
        int sum = 0;
        for (int num:nums){
            sum+=num;
        }
        int size = (target+sum)/2;
        if (size%2!=0){
            return 0;
        }
        if (size<0){
            size = -size;
        }
        int[] dp = new int[size+1];
        dp[0] = 1;
        for (int i=0;i<n;i++){
            for (int j=size;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[size];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int ans = new FindTargetSumWays().getTargetSum(nums,target);
        System.out.println(ans);
    }
}
