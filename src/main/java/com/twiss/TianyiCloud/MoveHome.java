package com.twiss.TianyiCloud;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/6/29 11:17 上午
 */
public class MoveHome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s1 = sc.nextLine().split(" ");
        String[] s2 = sc.nextLine().split(" ");
        int len = s1.length;
        int[] weight = new int[len];
        int[] value = new int[len];
        for (int i=0;i<len;i++){
            value[i] = Integer.parseInt(s1[i]);
            weight[i] = Integer.parseInt(s2[i]);
        }
        int[] dp = new int[n+1];
        for (int i=0;i<len;i++){
            // n表示总体力值
            for (int j=n;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
