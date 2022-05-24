package com.twiss.dynamic.substring;

/**
 * 两个字符串的删除操作
 * @Author: Twiss
 * @Date: 2022/5/24 4:00 下午
 */
public class MinDistance {

    public int getDistance(String s1,String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<m;i++){
           dp[i][0] = i;
        }
        for (int j=0;j<m;j++){
            dp[0][j] = j;
        }

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+2,
                            Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        int count = new MinDistance().getDistance(s1,s2);
        System.out.println(count);
    }
}
