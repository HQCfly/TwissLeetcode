package com.twiss.dynamic.stock;

/**
 * 买卖股票含手续费
 * @Author: Twiss
 * @Date: 2022/5/20 12:08 下午
 */
public class SellStockWithFee {

    public int getMaxProfit(int[] prices,int fee){
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i=1;i<prices.length;i++){
            dp[0] = Math.max(dp[0],dp[1]-prices[i-1]);
            dp[1] = Math.max(dp[1],dp[0]+prices[i-1]-fee);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        int[] prices ={1, 3, 2, 8, 4, 9};
        int fee = 2;
        int ans = new SellStockWithFee().getMaxProfit(prices,fee);
        System.out.println(ans);
    }
}
