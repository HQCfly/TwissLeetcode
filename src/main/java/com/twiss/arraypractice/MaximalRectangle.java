package com.twiss.arraypractice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: Twiss
 * @Date: 2021/3/10 11:37 下午
 */
public class MaximalRectangle {

    public static int maxArea(int[][] numbers) {
        int m = numbers.length;
        if (m == 0) {
            return 0;
        }
        int n = numbers[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (numbers[i][j] == 1) {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int ret = 0;
        for (int j = 0; j < n; j++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.empty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.empty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.empty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.empty() ? -1 : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int hight = down[i] - up[i] - 1;
                int area = hight * left[i][j];
                ret = Math.max(ret, area);
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[][] numbers = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int res = maxArea(numbers);
        System.out.println(res);
    }
}
