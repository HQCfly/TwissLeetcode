package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

/**
 * 叠书
 * 动态规划
 * @Author: Twiss
 * @Date: 2022/7/2 9:21 下午
 */
public class StackOfBook {

    public int getCount(int[][] books){
        if (books==null||books.length==0){
            return 0;
        }
        int n = books.length;
        int[] dp = new int[n+1];
        dp[0] = 1;
        int maxCount = 0;
        for (int i=1;i<n;i++){
            int l = books[i][0];
            int w = books[i][1];
            dp[i] = 1;
            for (int j=0;j<i;j++){
                int ll = books[j][0];
                int ww = books[j][1];
                // 长宽同时小于
                if ((l>ll&&w>ww)||(l<ll&&w<ww)){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxCount = Math.max(maxCount,dp[i]);
        }
        return dp[maxCount];
    }

    public static void main(String[] args) {
//        int[][] books = {
//                {20,16},
//                {15,11},
//                {10,10},
//                {9,10}
//        };
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            int[][] books = new int[n][2];
            for (int i=0;i<n;i++){
                String[] book = sc.nextLine().split(" ");
                books[i][0] = Integer.parseInt(book[0]);
                books[i][1] = Integer.parseInt(book[1]);
            }
            int ans = new StackOfBook().getCount(books);
            System.out.println(ans);

        }

    }
}
