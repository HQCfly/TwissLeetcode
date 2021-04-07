package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/7 9:37 下午
 */
public class RotateImage {

    public static int[][] getRotateImage(int[][] numbers) {
        int n = numbers.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                res[j][n - i - 1] = numbers[i][j];
            }
        }
        return res;
    }

    public static int[][] getRotateImage2(int[][] numbers) {
        int n = numbers.length;
        // 水平翻转
        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < n/2; ++j) {
                int temp = numbers[i][j];
                numbers[i][j] = numbers[n - i - 1][j];
                numbers[n - i - 1][j] = temp;
            }
        }
        // 对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = numbers[i][j];
                numbers[i][j] = numbers[j][i];
                numbers[j][i] = temp;
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] res = getRotateImage(numbers);
        System.out.println(JSONObject.toJSONString(res));

        int[][] numbers2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] res2 = getRotateImage2(numbers2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
