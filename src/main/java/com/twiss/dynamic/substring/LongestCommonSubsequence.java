package com.twiss.dynamic.substring;

/**
 * 最长公共子序列
 *
 * @Author: Twiss
 * @Date: 2022/5/22 2:46 下午
 */
public class LongestCommonSubsequence {

    public int getMaxLength(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            char c1 = s1.charAt(i-1);
            for (int j=1;j<=n;j++){
                char c2 = s2.charAt(j-1);
                if (c1==c2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ace";
        String s2 = "abcde";
        int ans = new LongestCommonSubsequence().getMaxLength(s1,s2);
        System.out.println(ans);
    }
}
