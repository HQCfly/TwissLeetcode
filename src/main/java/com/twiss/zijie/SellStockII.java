package com.twiss.zijie;

/**
 * 买股票II
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/19 10:47 下午
 */
public class SellStockII {

    public int getMaxProfit(int[] prices){
        int n = prices.length;
        int ans = 0;
        for (int i=1;i<n;i++){
            ans+=Math.max(0,prices[i]-prices[i-1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices =  {7,1,5,3,6,4};
        int ans = new SellStockII().getMaxProfit(prices);
        System.out.println(ans);
    }
}
