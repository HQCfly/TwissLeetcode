package com.twiss.huawei;

import java.util.*;

/**
 * 分糖果I
 *  DP动态规划
 * @Author: Twiss
 * @Date: 2022/7/6 9:06 下午
 */
public class DivideCandy {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
        }
        if (sum % 2 == 1 || N == 1) {
            System.out.println(-1);
            return;
        }
        int target = sum / 2;
        // 表示从下标0-i中任取，放入容量为j的背包，价值总和
        boolean[][] dp = new boolean[N + 1][target + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // 通过dp可以判断选择前几袋糖果是否可以找到和为target，然后把选择的结果加入list
        List<Integer> list = new ArrayList<>();
        while (target > 0) {
            for (int i = 1; i <= N; i++) {
                if (dp[i][target]) {
                    list.add(nums[i - 1]);
                    target -= nums[i - 1];
                    N = i - 1;
                    break;
                }
            }
        }
        // 后面全部是输出的内容
        Map<Integer, Integer> map = new HashMap<>();  // 存储每袋糖果数量出现的次数，用于处理输出
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(sum / 2);  // 输出每人分到的糖果总数,target已经变了
        // 第一个同学分配到的每袋糖果的糖果数
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        // 第二个同学分配到的每袋糖果的糖果数
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (map.get(num) > 0) {
                list2.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (i == list2.size() - 1) {
                System.out.println(list2.get(i));
            } else {
                System.out.print(list2.get(i) + " ");
            }
        }
    }
}
