package com.twiss.greed;

/**
 * 买股票II
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/1 11:14 下午
 */
public class SellStockII {

    public int getMaxProfit(int[] stocks){
        int result = 0;
        for (int i=1;i<stocks.length;i++){
            result+=Math.max(stocks[i]-stocks[i-1],0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] stocks = {7,1,5,10,3,6,4};
        int ans = new SellStockII().getMaxProfit(stocks);
        System.out.println(ans);
    }
}
