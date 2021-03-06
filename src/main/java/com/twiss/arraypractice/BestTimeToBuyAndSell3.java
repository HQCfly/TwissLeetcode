package com.twiss.arraypractice;

public class BestTimeToBuyAndSell3 {
    public static int maxProfit(int[] prices) {
        if (prices==null||prices.length==0){
            return 0;
        }
        int[] global = new int[3];
        int[] local = new int[3];
        for (int i=0;i<prices.length-1;++i){
            int diff = prices[i+1]-prices[i];
            for (int j = 2;j>0;j--){
                local[j] = Math.max(global[j-1]+diff,local[j]+diff);
                global[j] = Math.max(global[j],local[j]);
            }
        }
        System.out.println(global[2]);
        return global[2];
    }

    public static int maxProfit2(int[] prices){
        if (prices==null||prices.length==0){
            return 0;
        }
        int profit = 0;
        int n = prices.length-1;
        int[] left = new int[n];
        int min = prices[0];
        for (int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        int[] right = new int[n];
        int max = prices[n];
        for (int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],max-prices[i]);
            max = Math.max(max,prices[i]);

            profit = Math.max(profit,left[i]+right[i]);
        }
        System.out.println(profit);
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        maxProfit(prices);
        maxProfit2(prices);
    }
}
