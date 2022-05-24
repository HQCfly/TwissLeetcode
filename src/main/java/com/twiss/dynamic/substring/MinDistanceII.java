package com.twiss.dynamic.substring;

/**
 * 最短编辑距离
 *
 * @Author: Twiss
 * @Date: 2022/5/24 4:19 下午
 */
public class MinDistanceII {

    public int getDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String  s1 = "horse";
        String  s2 = "ros";
        int ans = new MinDistanceII().getDistance(s1,s2);
        System.out.println(ans);
    }
}
