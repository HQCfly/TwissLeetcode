package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/12 8:09 下午
 */
public class SetMatrixZeroes {

    public static int[][] getMatrixZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static int[][] getMatrixZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean row0 = false;
        boolean col0 = false;
        // 使用两个变量（r0 & c0），记录「首行 & 首列」是否该被置零
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                row0 = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                col0 = true;
            }
        }

        // 2.1 扫描「非首行首列」的位置，如果发现零，
        // 将需要置零的信息存储到该行的「最左方」和「最上方」的格子内

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 2.2 根据刚刚记录在「最左方」和「最上方」格子内的置零信息，
        // 进行「非首行首列」置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if (col0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] res = getMatrixZeroes(numbers);
        System.out.println(JSONObject.toJSONString(res));

        int[][] numbers2 = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        int[][] res2 = getMatrixZeroes2(numbers2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
