package com.twiss.dynamic;

/**
 * 整数拆分
 * @Author: Twiss
 * @Date: 2022/5/12 8:09 下午
 */
public class IntegerBreak {

    public int getMax(int n){
        int[] dp = new int[n+1];
        dp[2]=1;
        for (int i=3;i<=n;i++){
            for (int j=1;j<i-j;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[i-j]*j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n =10;
        int ans = new IntegerBreak().getMax(n);
        System.out.println(ans);
    }
}
