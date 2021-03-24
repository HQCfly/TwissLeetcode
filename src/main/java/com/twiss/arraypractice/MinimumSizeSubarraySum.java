package com.twiss.arraypractice;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/3/24 8:40 下午
 */
public class MinimumSizeSubarraySum {

    public static int solved(int[] numbers, int s) {
        int ans = Integer.MAX_VALUE;
        int n = numbers.length;
        if (n == 0) {
            return 0;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int target = s + sum[i - 1];
            int bound = Arrays.binarySearch(sum, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static int solved2(int[] numbers, int s) {
        int n = numbers.length;
        if (n == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < n) {
            sum += numbers[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= numbers[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 2, 4, 3};
        int res = solved(numbers, 7);
        System.out.println(res);
        int[] numbers2 = {2, 3, 1, 2, 4, 3};
        int res2 = solved2(numbers2, 7);
        System.out.println(res2);
    }
}
