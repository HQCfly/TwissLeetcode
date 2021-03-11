package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/3/11 10:48 下午
 */
public class MaximumProductSubarray {

    public static int maxSubarray(int[] numbers) {
        int maxF = numbers[0], minF = numbers[0], ans = numbers[0];
        for (int i = 1; i < numbers.length; ++i) {
            int max = maxF, min = minF;
            maxF = Math.max(max * numbers[i], Math.max(numbers[i], numbers[i] * min));
            minF = Math.min(max * numbers[i], Math.min(numbers[i], numbers[i] * min));
            ans = Math.max(maxF,ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, -2, 4};
        int res = maxSubarray(numbers);
        System.out.println(res);
    }
}
