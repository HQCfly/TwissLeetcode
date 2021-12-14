package com.twiss.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/12/1 11:27 下午
 */
public class TrappingRainWater {

    private int getTrappingRainWater(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    private int getTrapBySingleStack(int[] height){
        int ans = 0;
        Deque<Integer> deque = new LinkedList<Integer>();
        int n = height.length;
        for (int i=0;i<n;++i){
            while (!deque.isEmpty()&&height[i]>height[deque.peek()]){
                int top = deque.pop();
                if (deque.isEmpty()){
                    break;
                }
                int left = deque.peek();
                int currentWidth = i-left-1;
                int currentHeight = Math.min(height[left],height[i])-height[top];
                ans += currentHeight*currentWidth;
            }
            deque.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = new TrappingRainWater().getTrappingRainWater(height);
        System.out.println(ans);
        int[] height2 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans2 = new TrappingRainWater().getTrapBySingleStack(height2);
        System.out.println(ans2);
    }
}
