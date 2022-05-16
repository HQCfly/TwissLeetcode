package com.twiss.dynamic;

/**
 * @Author: Twiss
 * @Date: 2022/5/16 12:42 下午
 */
public class CombinationSumIV {

    public int getCombination(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] =1;
        for (int i=0;i<=target;i++){
            for (int j=0;j<nums.length;j++){
                if (i>=nums[j]){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int ans = new CombinationSumIV().getCombination(nums,target);
        System.out.println(ans);
    }
}
