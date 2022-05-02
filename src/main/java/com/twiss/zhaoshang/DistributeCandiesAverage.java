package com.twiss.zhaoshang;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/5/2 8:20 下午
 */
public class DistributeCandiesAverage {

    private static Boolean[] used;

    public static String canAverageDistribute(int[] candies) {
        if (candies == null || candies.length < 3) {
            return "NO";
        }
        int n = candies.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        int average = sum / 3;
        if (sum % 3 == 1) {
            return "NO";
        }
        used = new Boolean[n];
        for (int i = 1; i < 4; i++) {
            if (!dfs(candies, n, 0, average, 0)) {
                return "NO";
            }
        }
        return "YES";
    }

    private static boolean dfs(int[] nums, int len,
                               int depth, int average, int preSum) {
        // 递归出口
        if (average == preSum) {
            return true;
        }
        if (depth == len) {
            return false;
        }
        // 全排列
        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }
            preSum += nums[i];
            used[i] = true;
            if (dfs(nums, len, depth + 1, average, preSum)) {
                return true;
            } else {
                used[i] = false;
                preSum -= nums[i];
            }
        }
        return average == preSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testNumber = sc.nextInt();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < testNumber; i++) {
            int candiesNumbers = sc.nextInt();
            int[] candies = new int[candiesNumbers];
            sc.nextLine();
            String[] rowArrays = sc.nextLine().split(" ");
            for (int j = 0; j < candiesNumbers; ++j) {
                candies[i] = Integer.parseInt(rowArrays[j]);
            }
            String res = canAverageDistribute(candies);
            ans.add(res);
        }
        for (String res : ans){
            System.out.println(res);
        }
    }
}
