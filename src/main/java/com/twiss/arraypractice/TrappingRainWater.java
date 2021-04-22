package com.twiss.arraypractice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/4/22 11:01 下午
 */
public class TrappingRainWater {

    public static int getTrappingRainWaterInDp(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        int ans = 0;
        // 求i左边最大高度
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 求i右边最大高度
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // 取i左右两边最小高度，然后减去i的高度
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    public static int getTrappingRainWaterInStack(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
               int top = stack.pop();
               if (stack.isEmpty()){
                   break;
               }
               int left = stack.peek();
               int currentWight =
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = getTrappingRainWaterInDp(height);
        System.out.println(res);
    }
}
