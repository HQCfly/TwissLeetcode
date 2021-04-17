package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/4/16 10:34 下午
 */
public class SpiralMatrix {

    public static List<Integer> getSpiralMatrix1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        if (matrix == null || rows == 0 || columns == 0) {
            return res;
        }
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0],
                    nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows
                    || nextColumn >= columns || nextColumn < 0
                    || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return res;
    }

    public static List<Integer> getSpiralMatrix2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        if (matrix == null || rows == 0 || columns == 0) {
            return res;
        }
        int top = 0, left = 0, right = columns - 1, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 从左到右遍历上侧元素
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }
            // 从上到下遍历右侧元素
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }
            // 如果left<right且top<bottom，则从右到左遍历下侧元素
            if (left < right && top < bottom) {
                // 从右到左遍历下侧元素
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]);
                }
                // 从下到上遍历左侧元素
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> res = getSpiralMatrix1(matrix);
        System.out.println(JSONObject.toJSONString(res));

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> res2 = getSpiralMatrix2(matrix2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
