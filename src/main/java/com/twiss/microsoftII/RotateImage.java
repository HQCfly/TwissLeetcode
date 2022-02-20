package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

/**
 * 旋转图像
 *
 * @Author: Twiss
 * @Date: 2022/2/20 2:06 下午
 */
public class RotateImage {

    public int[][] getRotateImage(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        int[][] newMatrix = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            int newCol = rowLen - i - 1;
            for (int j = 0; j < colLen; j++) {
                newMatrix[j][newCol] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] ans = new RotateImage().getRotateImage(matrix);
        System.out.println(JSONObject.toJSONString(ans));

        int[][] matrix2 = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        int[][] ans2 = new RotateImage().getRotateImage(matrix2);
        System.out.println(JSONObject.toJSONString(ans2));
    }
}
