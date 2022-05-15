package com.twiss.dynamic;

/**
 * 零钱兑换
 * 组合类问题
 * @Author: Twiss
 * @Date: 2022/5/15 3:25 下午
 */
public class Change {

    public int getCombinations(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<=amount;j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        int ans = new Change().getCombinations(amount,coins);
        System.out.println(ans);
    }
}
