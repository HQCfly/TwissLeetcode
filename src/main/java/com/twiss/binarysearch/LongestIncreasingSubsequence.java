package com.twiss.binarysearch;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/7/25 8:25 下午
 */
public class LongestIncreasingSubsequence {

    private int getLISByDp(int[] array){
        int len = array.length;
        int[] dp = new int[array.length];
        Arrays.fill(dp,1);
        int res = 0;
        for (int i=1;i<len;i++){
            for (int j=0;j<i;j++){
                if (array[i]>array[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    private int getLISByBinarySearch(int[] array){
        int[] tail = new int[array.length];
        int res = 0;
        for (int num:array){
            int l=0,h=res;
            while (l<h){
                int mid = l+(h-l)/2;
                if (tail[mid]<num){
                    l = mid+1;
                }else {
                    h = mid;
                }
            }
            tail[l] = num;
            if (h==res){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        int res = new LongestIncreasingSubsequence().getLISByDp(array);
        System.out.println(res);
        int res2 = new LongestIncreasingSubsequence().getLISByBinarySearch(array);
        System.out.println(res2);
    }
}
