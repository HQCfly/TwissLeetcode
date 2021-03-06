package com.twiss.arraypractice;

public class BestTimeToBuyAndSell2 {
    public static int solution(int[] prices){
        int profit = 0;
        for (int i = 0; i < prices.length-1; ++i){
            profit += Math.max(0,prices[i+1]-prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        solution(prices);
    }
}
