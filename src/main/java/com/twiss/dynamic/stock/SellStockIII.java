package com.twiss.dynamic.stock;

/**
 * 买卖股票III
 * @Author: Twiss
 * @Date: 2022/5/19 1:25 下午
 */
public class SellStockIII {

    public int getMaxProfit(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int[] dp = new int[4];
        // 0代表第一次交易买入
        dp[0] = -prices[0];
        // 1代表第一次交易卖出
        dp[1] = 0;
        // 2代表第二次交易买入
        dp[2] = -prices[0];
        // 3代表第二次交易卖出
        dp[3] = 0;
        for (int i=1;i<prices.length;i++){
            dp[0] = Math.max(dp[0],-prices[i-1]);
            dp[1] = Math.max(dp[1],dp[0]+prices[i-1]);
            dp[2] = Math.max(dp[2],dp[1]-prices[i-1]);
            dp[3] = Math.max(dp[3],dp[2]+prices[i-1]);
        }
        return dp[3];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        int ans = new SellStockIII().getMaxProfit(prices);
        System.out.println(ans);
    }
}
