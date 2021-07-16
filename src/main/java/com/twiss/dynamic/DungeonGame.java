package com.twiss.dynamic;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/7/16 2:44 下午
 */
public class DungeonGame {

    private int calculateMinimumHP(int[][] matrix) {
        // dp[i][j] 表示从坐标 (i,j) 到终点所需的最小初始值
        // 当我们到达坐标 (i,j) 时，如果此时我们的路径和不小于dp[i][j]，我们就能到达终点。
        int n = matrix.length, m = matrix[0].length;
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n - 1][m] = dp[n][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max((min - matrix[i][j]), 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}
        };

        DungeonGame dungeonGame = new DungeonGame();
        int res = dungeonGame.calculateMinimumHP(matrix);
        System.out.println(res);
    }
}
