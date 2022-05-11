package com.twiss.dynamic;

/**
 * 有障碍的不同路径
 * @Author: Twiss
 * @Date: 2022/5/11 1:16 下午
 */
public class UniquePathsWithObstacles {

    public int getPath(int[][] grids){
        if (grids==null||grids.length==0){
            return 0;
        }
        int n = grids.length, m = grids[0].length;
        int[][] dp = new  int[n][m];
        for (int i=0;i<m;i++){
            if (grids[0][i]==1){
                break;
            }
            dp[0][i] = 1;
        }
        for (int j=0;j<m;j++){
            if (grids[j][0]==1){
                break;
            }
            dp[j][0] = 1;
        }

        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (grids[i][j]==1){
                    continue;
                }
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int[][] grids = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int ans = new UniquePathsWithObstacles().getPath(grids);
        System.out.println(ans);
    }
}
