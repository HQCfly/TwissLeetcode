package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;


/**
 * @Author: Twiss
 * @Date: 2021/4/16 10:34 下午
 */
public class SpiralMatrixII {

    public static int[][] getSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int i = 1;
        int top = 0, left = 0, right = columns - 1, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左到右遍历上侧元素
            for (int column = left; column <= right; column++) {
                matrix[top][column] = i;
                i++;
            }
            // 从上到下遍历右侧元素
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = i;
                i++;
            }
            // 如果left<right且top<bottom，则从右到左遍历下侧元素
            if (left < right && top < bottom) {
                // 从右到左遍历下侧元素
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = i;
                    i++;
                }
                // 从下到上遍历左侧元素
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = i;
                    i++;
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] res = getSpiralMatrix(n);
        System.out.println(JSONObject.toJSONString(res));
    }
}
