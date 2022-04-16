package com.twiss.zijie;

/**
 * 最后一块石头的重量II
 * 时间复杂度O(n*sum of stones)
 * 空间复杂度O(n*sum of stones)
 * @Author: Twiss
 * @Date: 2022/4/16 7:50 下午
 */
public class LastStoneWeightII {

    public int getOptiValue(int[] stones){
        int n = stones.length;
        int sum = 0;
        for (int i : stones) sum += i;
        int t = sum / 2;
        int[][] f = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = 0; j <= t; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= x) f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + x);
            }
        }
        return Math.abs(sum - f[n][t] - f[n][t]);
    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
        int ans = new LastStoneWeightII().getOptiValue(stones);
        System.out.println(ans);
    }
}
