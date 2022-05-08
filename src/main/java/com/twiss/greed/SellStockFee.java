package com.twiss.greed;

/**
 * 买卖股票含有手续费
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/7 11:34 下午
 */
public class SellStockFee {

    public int getMaxProfit(int[] stocks,int fee){
        int buy = stocks[0]+fee;
        int sum = 0;
        for (int price:stocks){
            if (price+fee<buy){
                buy = price+fee;
            }else if (price>buy){
                sum+=price-buy;
                buy = price;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] stocks = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int ans = new SellStockFee().getMaxProfit(stocks,fee);
        System.out.println(ans);
    }
}
