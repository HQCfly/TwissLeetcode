package com.twiss.dynamic.substring;

/**
 * 最长回文子串
 * if s[i]==s[j] dp[i][j] = dp[i+1][j-1]
 * else dp[i][j] = Max()
 * @Author: Twiss
 * @Date: 2022/5/25 9:48 上午
 */
public class MaxLengthPalindrome {

    public int getMaxLength(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        int n=s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i=n-1;i>=0;i--){
            dp[i][i] = 1;
            // 主要计算上三角值
            for (int j=i+1;j<n;j++){
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] +2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        int ans = new MaxLengthPalindrome().getMaxLength(s);
        System.out.println(ans);
    }
}
