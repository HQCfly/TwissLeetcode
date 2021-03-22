package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/3/22 10:42 下午
 */
public class MinimumPathSum {
    private static int minPath(int[][] dp) {
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 && j == 0) {
                    continue;
                }
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i][j];
                }
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + dp[i][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[][] dp = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = minPath(dp);
        System.out.println(res);
    }
}
