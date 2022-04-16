package com.twiss.zijie;

/**
 * 长度最小子数组
 * 前缀和或者滑动窗口
 * 前缀和+二分法时间复杂度O(nlogN)
 * 前缀和+二分法空间复杂度O(N)
 * <p>
 * 滑动窗口时间复杂度O(n)
 * 滑动窗口空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/4/16 8:16 下午
 */
public class MinSubarray {

    public int getMinSubarray(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 7;
        int ans = new MinSubarray().getMinSubarray(s,nums);
        System.out.println(ans);
    }
}
