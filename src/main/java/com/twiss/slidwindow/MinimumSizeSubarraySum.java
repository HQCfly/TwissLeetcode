package com.twiss.slidwindow;

import java.util.Arrays;

/**
 * 长度最小的子数组
 *
 * @Author: Twiss
 * @Date: 2022/2/18 1:58 下午
 */
public class MinimumSizeSubarraySum {

    public int getMinimumSubarrayBySlidWindow(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int start = 0, end = 0; end < n; ++end) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return ans;
    }

    public int getMinimumByPreSum(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] preSum = new int[n + 1];
        int ans = Integer.MAX_VALUE;
        // 第0个前缀和还是0
        preSum[0] = 0;
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 使用二分法查找target在前缀和里面的位置
        for (int i = 1; i < n; i++) {
            int t = target+preSum[i-1];
            // 输入的是前缀和数组和 目标key
            int bound = Arrays.binarySearch(preSum,t);
            if (bound<0){
                bound = -bound-1;
            }
            if (bound<=n){
                ans = Math.min(ans,bound-(i-1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        int ans = new MinimumSizeSubarraySum()
                .getMinimumSubarrayBySlidWindow(nums, target);
        System.out.println(ans);

        int ans2 =new MinimumSizeSubarraySum()
                .getMinimumByPreSum(nums,target);
        System.out.println(ans2);
    }
}
