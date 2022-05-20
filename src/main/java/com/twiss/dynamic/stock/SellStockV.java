package com.twiss.dynamic.stock;

/**
 * 买卖股票五含冷冻期
 * @Author: Twiss
 * @Date: 2022/5/20 11:34 上午
 */
public class SellStockV {

    /**
     * 状态一：买入股票状态（今天买入股票，或者是之前就买入了股票然后没有操作）
     * dp[i][0] = Math.max(d[i-1][0],Math.max(dp[i-1][3],dp[i-1][1])-prices[i])
     * 卖出股票状态，这里就有两种卖出股票状态
     *      状态二：两天前就卖出了股票，度过了冷冻期，一直没操作，今天保持卖出股票状态
     *      dp[i][1] = Math.max(dp[i-1][1],dp[i-1][3])
     *      状态三：今天卖出了股票
     *      dp[i][2] = dp[i-1][0]+prices[i]
     * 状态四：今天为冷冻期状态，但冷冻期状态不可持续，只有一天！
     * dp[i][3] = dp[i-1][2]
     * @param prices
     * @return
     */
    public int getMaxProfit(int[] prices){
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i=1;i<=prices.length;i++){
            // 使用临时变量来保存dp[0],dp[2]
            // 因为马上dp[0]和dp[2]的数据会变
            int tmp1 = dp[0];
            int tmp2 = dp[2];
            dp[0] = Math.max(dp[0],Math.max(dp[3],dp[1])-prices[i-1]);
            dp[1] = Math.max(dp[1],dp[3]);
            dp[2] = tmp1+prices[i-1];
            dp[3] = tmp2;
        }
        return Math.max(dp[3],Math.max(dp[2],dp[1]));
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int ans = new SellStockV().getMaxProfit(prices);
        System.out.println(ans);
    }
}
