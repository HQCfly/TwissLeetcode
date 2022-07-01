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
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = Integer.parseInt(arr[i]);
            }
            int[] dp = new int[limit + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= limit; j++) {
                    if (i > 0 && values[i-1] <= j) {
                        dp[j] = Math.max(dp[j], dp[j - values[i-1]] + 1);
                    } else {
                        dp[j] = dp[j-1];
                    }
                }
            }
            System.out.println(dp[limit]);
        }
    }
}
