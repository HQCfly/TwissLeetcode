package com.twiss.dynamic;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/8/26 8:03 下午
 */
public class PerfectSquares {

    public int getPrefectSquare(int n){
        int[] dp = new int[n+1];
        for (int i=1;i<=n;++i){
            dp[i] = i;
            for (int j=1;i-j*j>=0;++j){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;

        int res = new PerfectSquares().getPrefectSquare(n);
        System.out.println(res);
    }
}
