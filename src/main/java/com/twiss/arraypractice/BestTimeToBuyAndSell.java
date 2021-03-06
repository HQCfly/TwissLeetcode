package com.twiss.arraypractice;

public class BestTimeToBuyAndSell {
    public static int solution(int[] prices){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i){
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        solution(prices);
    }

}
