package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2022/1/4 10:52 下午
 */
public class RotateImage {

    public void rotate(int[][] matrix){
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                matrix_new[j][n-i-1] = matrix[i][j];
            }
        }
        for (int i=0;i<n;++i){
            for (int j=0;j<n;++j){
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }

    public void rotateByTwoRotate(int[][] matrix){
        int n = matrix.length;
        // 水平翻转
        for(int i=0;i<n/2;++i){
            for (int j=0;j<n;++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = tmp;
            }
        }
        // 垂直翻转
        for(int i=0;i<n;++i){
            for (int j=0;j<i;++j){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new RotateImage().rotate(matrix);
        System.out.println(JSONObject.toJSONString(matrix));
        int[][] matrix2 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        new RotateImage().rotateByTwoRotate(matrix2);
        System.out.println(JSONObject.toJSONString(matrix2));

    }
}
