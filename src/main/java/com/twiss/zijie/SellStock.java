package com.twiss.zijie;

/**
 * 卖股票时机
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/4/3 7:55 下午
 */
public class SellStock {

    public int getMaxProfit(int[] stocks){
        if (stocks==null||stocks.length==0){
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0;i<stocks.length;++i){
            if (stocks[i]<minPrice){
                minPrice = stocks[i];
            }else if (stocks[i]-minPrice>maxProfit){
                maxProfit = stocks[i]-minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int profit = new SellStock().getMaxProfit(nums);
        System.out.println(profit);
    }
}
