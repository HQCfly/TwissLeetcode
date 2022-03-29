package com.twiss.island;

/**
 * 岛屿周长
 *
 * @Author: Twiss
 * @Date: 2022/3/15 6:19 下午
 */
public class IslandPerimeter2 {

    public int getPerimeter(int[][] grids) {
        for (int i = 0; i < grids.length; ++i) {
            for (int j = 0; j < grids[0].length; ++j) {
                if (grids[i][j] == 1) {
                    return dfs(grids, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grids, int i, int j) {
        if (!inArea(grids, i, j) || grids[i][j] == 0) {
            return 1;
        }
        if (grids[i][j] != 1) {
            return 0;
        }
        grids[i][j] = 2;
        return dfs(grids, i - 1, j) +
                dfs(grids, i + 1, j) +
                dfs(grids, i, j - 1) +
                dfs(grids, i, j + 1);
    }

    private boolean inArea(int[][] grids, int i, int j) {
        return 0 <= i && i < grids.length &&
                0 <= j && j < grids[0].length;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0},
        };
        int ans = new IslandPerimeter2().getPerimeter(grids);
        System.out.println(ans);
    }
}
