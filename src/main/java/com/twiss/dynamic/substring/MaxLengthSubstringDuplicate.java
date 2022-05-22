package com.twiss.dynamic.substring;

/**
 * 最长重复子数组
 * @Author: Twiss
 * @Date: 2022/5/21 1:34 下午
 */
public class MaxLengthSubstringDuplicate {

    public int getMax(int[] num1,int[] num2){
        int n = num1.length+1, m = num2.length+1;
        int[][] dp = new int[n][m];

        int res = 0;
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (num1[i-1]==num2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j],res);
                }
            }
        }
        return res;
    }

    public int getMaxByOneDimension(int[] num1,int[] num2){
        int n = num1.length+1, m = num2.length+1;
        int[] dp = new int[m];

        int res = 0;
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (num1[i-1]==num2[j-1]){
                    dp[j] = dp[j-1]+1;
                    res = Math.max(dp[j],res);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,2,1};
        int[] num2 = {3,2,1,4,7};
        int ans = new MaxLengthSubstringDuplicate().getMax(num1,num2);
        System.out.println(ans);

        int ans2 = new MaxLengthSubstringDuplicate().getMax(num1,num2);
        System.out.println(ans2);
    }
}
