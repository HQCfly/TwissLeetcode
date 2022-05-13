package com.twiss.dynamic;

/**
 * 不同的二叉搜索树
 * @Author: Twiss
 * @Date: 2022/5/13 5:26 下午
 */
public class NumTrees {

    public int getNum(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        int ans = new NumTrees().getNum(n);
        System.out.println(ans);
    }
}
