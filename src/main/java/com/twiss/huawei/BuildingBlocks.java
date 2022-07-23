package com.twiss.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 叠积木
 * @Author: Twiss
 * @Date: 2022/7/23 10:14 下午
 */
public class BuildingBlocks {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        // 去掉字符串的所有括号，这里注意下字符串的解析
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("\\]", "");
//        str = str.replaceAll("\\s+", "");  // 去掉所有空格
        String[] str1 = str.split(",");
        int[][] nums = new int[str1.length / 2][2];
        for (int i = 0; i < nums.length; i++) {
            int num1 = Integer.parseInt(str1[2 * i]);
            int num2 = Integer.parseInt(str1[2 * i + 1]);
            nums[i][0] = Math.max(num1, num2);  // 大的为长度
            nums[i][1] = Math.min(num1, num2);  // 小的为宽度
        }
        // 先对积木自定义排序，按长度降序，相同按宽度降序
        Arrays.sort(nums, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]);
        // 动态规划，dp[i] 表示如果积木为 i 时，最大积木嵌套数
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);  // 初始化为1
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j][1] >= nums[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 当前值，或从0到i-1中找到宽大于当前积木的
                }
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}
