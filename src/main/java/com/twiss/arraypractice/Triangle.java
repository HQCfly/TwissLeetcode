package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/4/23 10:04 下午
 */
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangles) {
        int n = triangles.size();
        int[][] dp = new int[n + 1][n+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1]) + triangles.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public static int minimumTotal2(List<List<Integer>> triangles) {
        int n = triangles.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j],dp[j+1]) + triangles.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangles = new ArrayList<>();
        triangles.add(Arrays.asList(2));
        triangles.add(Arrays.asList(3, 4));
        triangles.add(Arrays.asList(6, 5, 7));
        triangles.add(Arrays.asList(4, 1, 8, 3));
        int res = minimumTotal(triangles);
        System.out.println(res);

        int res2 = minimumTotal2(triangles);
        System.out.println(res2);
    }
}
