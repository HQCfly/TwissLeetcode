package com.twiss.dynamic;

/**
 * 不同路径
 * @Author: Twiss
 * @Date: 2022/5/10 5:52 下午
 */
public class UniquePaths {

    /**
     * dp[i][j]表示到达i行j列的所有路径
     * dp[i][j] = dp[i-1][j]+d[i][j-1]
     * @param rows
     * @return
     */
    public int getPaths(int rows, int columns){
        int[][] dp = new int[rows][columns];

        for (int i=0;i<rows;i++){
            dp[i][0] = 1;
        }
        for (int j=0;j<columns;j++){
            dp[0][j] = 1;
        }
        for (int i=1;i<rows;i++){
            for (int j= 1;j<columns;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args) {
        int m= 3, n = 3;
        int ans = new UniquePaths().getPaths(m,n);
        System.out.println(ans);
    }
}
