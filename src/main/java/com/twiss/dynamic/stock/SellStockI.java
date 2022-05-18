package com.twiss.dynamic.stock;

/**
 * 买股票I
 * 贪心和动态规划
 * @Author: Twiss
 * @Date: 2022/5/18 4:06 下午
 */
public class SellStockI {

    public int getMaxProfit(int[] prices){
        int low = Integer.MAX_VALUE;
        if (prices==null||prices.length==0){
            return 0;
        }
        int result = 0;
        for (int i=0;i<prices.length;i++){
            low = Math.min(low,prices[i]);
            result = Math.max(prices[i]-low,result);
        }
        return result;
    }

    public int getMaxProfitByDp(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int n = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i=1;i<n;i++){
            dp[i][0] =Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[n-1][1];
    }


    public static void main(String[] args) {
        int[] stocks = {7,1,5,3,6,4};
        int profit = new SellStockI().getMaxProfit(stocks);
        System.out.println(profit);
        int profit2 = new SellStockI().getMaxProfitByDp(stocks);
        System.out.println(profit2);
    }
}
