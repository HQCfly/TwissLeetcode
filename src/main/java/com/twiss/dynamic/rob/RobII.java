package com.twiss.dynamic.rob;

/**
 * 打家劫舍II
 * 首尾不能相邻
 * @Author: Twiss
 * @Date: 2022/5/18 12:18 下午
 */
public class RobII {

    public int getMaxProfit(int[] money) {
        if (money == null || money.length == 0) {
            return 0;
        }
        int n = money.length;
        if (n == 1) {
            return money[0];
        }
        int ans = Math.max(robAction(money, 0, n - 1),
                robAction(money, 1, n));
        return ans;
    }

    private int robAction(int[] money, int start, int end) {
        int curr = 0, tmp = 0, previous = 0;
        for (int i = start; i < end; i++) {
            tmp = curr;
            curr = Math.max(tmp,previous+money[i]);
            previous = tmp;
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] money = {2,3,2};
        int ans = new RobII().getMaxProfit(money);
        System.out.println(ans);
    }
}
