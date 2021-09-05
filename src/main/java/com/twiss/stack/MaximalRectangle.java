package com.twiss.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Twiss
 * @Date: 2021/9/5 1:48 下午
 */
public class MaximalRectangle {

    public int getMaxArea(int[][] matrix){
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        // 计算每个点的代表的列与0之前的距离
        // 如：0 1 1 0
        // [0, 1, 2, 0]
        // 表示第二列的宽度是1，第三列宽度是2，第四列宽度是0
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (matrix[i][j] == 1) {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j=0;j<n;++j){
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i=0;i<m;++i){
                while (!(stack.isEmpty())&&(left[stack.peek()][j]>=left[i][j])){
                    stack.pop();
                }
                up[i] = stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i=m-1;i>=0;--i){
                while (!(stack.isEmpty())&&(left[stack.peek()][j]>=left[i][j])){
                    stack.pop();
                }
                down[i] = stack.isEmpty()?m:stack.peek();
                stack.push(i);
            }

            for (int i= 0;i<m;++i){
                int height = down[i]-up[i]-1;
                int area = height*left[i][j];
                ret = Math.max(ret,area);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int res = new MaximalRectangle().getMaxArea(numbers);
        System.out.println(res);
    }
}
