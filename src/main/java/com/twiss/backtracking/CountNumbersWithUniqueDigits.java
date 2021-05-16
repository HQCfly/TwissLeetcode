package com.twiss.backtracking;

/**
 * @Author: Twiss
 * @Date: 2021/5/16 7:31 下午
 */
public class CountNumbersWithUniqueDigits {

    private int getCountNumber(int n) {
        if (n == 0) return 1;
        return dfs(Math.min(10, n), 0, new boolean[10]);
    }

    private int dfs(int n, int index, boolean[] used) {
        int count = 0;
        if (index != n) {
            for (int i = 0; i < 10; i++) {
                if (i == 0 && n > 1 && index == 1) {
                    continue;
                }
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                count += dfs(n, index + 1, used) + 1;
                used[i] = false;
            }

        }
        return count;
    }

    /**
     * 排列组合：n位有效数字 = 每一位都从 0~9 中选择，且不能以 0 开头
     * 1位数字：0~9                      10
     * 2位数字：C10-2，且第一位不能是0      9 * 9
     * 3位数字：C10-3，且第一位不能是0      9 * 9 * 8
     * 4位数字：C10-4，且第一位不能是0      9 * 9 * 8 * 7
     * ... ...
     * 最后，总数 = 所有 小于 n 的位数个数相加
     */
    private int getCountNumber2(int n) {
        if (n == 0) return 1;
        int first = 10, second = 9 * 9;
        int size = Math.min(n, 10);
        for (int i = 2; i <= size; i++) {
            first += second;
            second *= 10 - i;
        }
        return first;
    }

    public static void main(String[] args) {
        int n = 2;
        int res = new CountNumbersWithUniqueDigits().getCountNumber(n);
        System.out.println(res);
        int res2 = new CountNumbersWithUniqueDigits().getCountNumber2(n);
        System.out.println(res2);
    }
}
