package com.twiss.microsoft;

import java.util.Random;

/**
 * 乘积最大子数组
 *
 * @Author: Twiss
 * @Date: 2022/2/14 2:31 下午
 */
public class MaxProduct {

    public int getMaxProduct(int[] nums) {
        int n = nums.length, maxP = nums[0], minP = nums[0];
        int ans = nums[0];
        for (int i = 1; i < n; ++i) {
            int mx = maxP, mn = minP;
            maxP = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minP = Math.max(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxP, minP);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int ans = new MaxProduct().getMaxProduct(nums);
        System.out.println(ans);
    }
}
