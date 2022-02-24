package com.twiss.microsoftII;

/**
 * 岛屿数量
 * DFS
 * 时间复杂度O()
 *
 * @Author: Twiss
 * @Date: 2022/2/24 3:32 下午
 */
public class TheNumbersOfIsland {

    public int getNumbers(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int res = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        for (int i = 0; i < rowLen; ++i) {
            for (int j = 0; j < colLen; ++j) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (!isInArea(grid, i, j) || grid[i][j] != 1) {
            return;
        }
        // 修改访问过的状态
        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    private boolean isInArea(int[][] grid, int i, int j) {
        return (0 <= i && i < grid.length) && (0 <= j && j < grid[0].length);
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
        };
        int ans = new TheNumbersOfIsland().getNumbers(grids);
        System.out.println(ans);
    }
}
