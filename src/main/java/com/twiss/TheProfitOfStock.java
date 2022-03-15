package com.twiss;

/**
 * @Author: Twiss
 * @Date: 2022/3/15 7:50 下午
 */
public class TheProfitOfStock {

    public int getProfit(int[] arrays,int m,int k){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=0;i<arrays.length;++i){
            max = Math.max(max,arrays[i]-min);
            min = Math.min(min,arrays[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3, -7, 8, -5, 9};
        // output 12
        int ans = new TheProfitOfStock().getProfit(nums,2,15);
    }
}
