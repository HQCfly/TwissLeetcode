package com.twiss.dynamic;

/**
 * 斐波那契数列
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/5/9 10:14 下午
 */
public class Fib {

    public int getN(int n){
        if (n<2){
            return n;
        };
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int n=5;
        int ans = new Fib().getN(n);
        System.out.println(ans);
    }
}
