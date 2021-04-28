package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/27 8:43 下午
 */
public class UniquePaths {

    public static int getSumOfPaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i-1][j]+f[i][j-1];
            }
        }

        return f[m - 1][n - 1];
    }

    public static int getSumOfPathsInMath(int m, int n) {
        int ans = 1;
        for (int x=n,y=1;y<m;++x,++y){
            ans = ans * x/y;
        }

        return ans;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int res = getSumOfPaths(m, n);
        int res2 = getSumOfPathsInMath(m, n);
        System.out.println(res);
        System.out.println(res2);
    }
}
