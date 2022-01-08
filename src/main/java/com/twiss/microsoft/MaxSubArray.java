package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2022/1/8 11:54 上午
 */
public class MaxSubArray {

    public int getMaxResultByDp(int[] nums) {
        int pre = 0, sum = nums[0];
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            sum = Math.max(pre, sum);
        }
        return sum;
    }

    public int getMaxResultByDivide(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, n - 1);
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return maxThree(
                maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right)
        );
    }

    private int maxThree(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = new MaxSubArray().getMaxResultByDp(nums);
        System.out.println(JSONObject.toJSONString(res));

        int[] nums2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res2 = new MaxSubArray().getMaxResultByDivide(nums2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
