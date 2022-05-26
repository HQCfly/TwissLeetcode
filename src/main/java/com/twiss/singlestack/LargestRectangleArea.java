package com.twiss.singlestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 *
 * @Author: Twiss
 * @Date: 2022/5/26 3:22 下午
 */
public class LargestRectangleArea {

    public int getLargestRectangle(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[height.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < height.length; index++){
            newHeights[index + 1] = height[index];
        }

        height = newHeights;
        int result = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            int stackTop = stack.peek();
            if (height[i] > height[stackTop]) {
                stack.push(i);
            } else if (height[i] == height[stackTop]) {
                stack.pop();
                stack.push(i);
            } else {
                int heightIndex = height[i];
                while (!stack.isEmpty() && (heightIndex < height[stackTop])) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h = height[mid];
                        int hold = (i-left-1)*h;
                        result = Math.max(result,hold);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        int ans = new LargestRectangleArea().getLargestRectangle(height);
        System.out.println(ans);
    }
}
