package com.twiss.dynamic.substring;

import java.util.Arrays;

/**
 * 最长上升子序列
 *
 * @Author: Twiss
 * @Date: 2022/5/20 1:21 下午
 */
public class MaxLengthIncreaseSubstring {

    public int getMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int ans = new MaxLengthIncreaseSubstring().getMaxLength(nums);
        System.out.println(ans);

    }
}
