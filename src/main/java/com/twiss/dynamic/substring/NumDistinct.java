package com.twiss.dynamic.substring;

/**
 * 不同子序列
 *
 * @Author: Twiss
 * @Date: 2022/5/23 2:30 下午
 */
public class NumDistinct {

    public int getDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        int ans = new NumDistinct().getDistinct(s, t);
        System.out.println(ans);
    }
}
