package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/5 12:31 下午
 */
public class LargestRectangleInHistogram {

    public int getArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<n;++i){
            while ((!stack.isEmpty())&&(heights[stack.peek()]>=heights[i])){
                stack.pop();
            }
            left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i=n-1;i>=0;i--){
            while ((!stack.isEmpty())&&(heights[stack.peek()]>=heights[i])){
                stack.pop();
            }
            right[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }

        int area = 0;
        for (int i=0;i<n;++i){
            area = Math.max(area,(right[i]-left[i]-1)*heights[i]);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,6,2,3};
        int area = new LargestRectangleInHistogram().getArea(array);
        System.out.println(area);
    }
}
