package com.twiss.dynamic.substring;

/**
 * 不相交的线
 * @Author: Twiss
 * @Date: 2022/5/23 11:22 上午
 */
public class MaxUncrossedLines {

    public int getMaxUncrossLines(int[] num1,int[] num2){
        int m = num1.length, n = num2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (num1[i-1]==num2[j-1]){
                    dp[i][j] = dp[i][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] num1 = {1,4,2};
        int[] num2 = {1,2,4};
        int ans = new MaxUncrossedLines().getMaxUncrossLines(num1,num2);
        System.out.println(ans);
    }
}
