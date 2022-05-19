package com.twiss.dynamic.stock;

/**
 * 买卖股票IV
 *
 * @Author: Twiss
 * @Date: 2022/5/19 4:54 下午
 */
public class SellStockIV {

    public int getMaxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[n - 1][k * 2];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        int k = 2;
        int ans = new SellStockIV().getMaxProfit(prices, k);
        System.out.println(ans);
    }
}
