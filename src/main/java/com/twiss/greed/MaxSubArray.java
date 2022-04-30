package com.twiss.greed;

/**
 * 最大子序和
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/4/30 9:27 下午
 */
public class MaxSubArray {

    public int getMaxResult(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int count = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arrays.length; i++) {
            count += arrays[i];
            sum = Math.max(sum, count);
            if (count < 0) {
                count = 0;
            }
        }
        return sum;
    }

    public int getMaxResultByDp(int[] arrays){
        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int[] dp = new int[arrays.length];
        dp[0] = arrays[0];
        int ans = dp[0];
        for (int i=1;i<arrays.length;i++){
            dp[i] = Math.max(arrays[i],dp[i-1]+arrays[i]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = new MaxSubArray().getMaxResult(nums);
        System.out.println(ans);
        int ans2 = new MaxSubArray().getMaxResultByDp(nums);
        System.out.println(ans2);
    }
}
