package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/27 8:43 下午
 */
public class UniquePathsII {

    public static int getSumOfPaths(int[][] path) {
        int n = path.length, m = path[0].length;
        int[] f = new int[m];
        f[0] = path[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (path[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && path[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }

    public static void main(String[] args) {
        int[][] path = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int res = getSumOfPaths(path);
        System.out.println(res);
    }
}
