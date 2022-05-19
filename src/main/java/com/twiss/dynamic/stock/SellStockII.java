package com.twiss.dynamic.stock;

/**
 * 买卖股票II
 * @Author: Twiss
 * @Date: 2022/5/19 11:32 上午
 */
public class SellStockII {

    public int maxProfit(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i=1;i<=prices.length;i++){
            dp[0] = Math.max(dp[0],dp[1]-prices[i-1]);
            dp[1] = Math.max(dp[1],dp[0]+prices[i-1]);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] prices ={1,2,3,4,5};
        int ans = new SellStockII().maxProfit(prices);
        System.out.println(ans);
    }
}
