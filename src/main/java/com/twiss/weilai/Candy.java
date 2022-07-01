package com.twiss.weilai;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/7/1 7:41 下午
 */
public class Candy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int limit = sc.nextInt();
            sc.nextLine();
            String[] arr = sc.nextLine().split(" ");
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(arr[i]);
            }
            int[] dp = new int[limit + 1];
            for (int i = 0; i < n; i++) {
                for (int j = limit; j >=weight[i]; j--) {
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+1);
                }
            }
            System.out.println(dp[limit]);
        }
    }
}
