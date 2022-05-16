package com.twiss.dynamic;

/**
 * 完全平方数
 * @Author: Twiss
 * @Date: 2022/5/16 1:49 下午
 */
public class NumSquares {

    public int getNum(int n){
        int max= Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = max;
        }

        dp[0] = 0;
        // 先遍历物品，在遍历背包
        for (int i=1;i*i<=n;i++){
            for (int j=i*i;j<=n;j++){
                if (dp[j-i*i]!=max){
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }

    public int getNumByPack(int n){
        int max= Integer.MAX_VALUE;
        int[] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = max;
        }

        dp[0] = 0;
        // 先遍历背包，在遍历物品
        for (int i=1;i<=n;i++){
            for (int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int ans = new NumSquares().getNum(n);
        System.out.println(ans);
        int ans2 = new NumSquares().getNumByPack(n);
        System.out.println(ans2);
    }
}
