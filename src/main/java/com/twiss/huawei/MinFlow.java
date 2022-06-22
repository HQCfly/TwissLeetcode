package com.twiss.huawei;

import java.util.Scanner;

/**
 * 最小传输时延
 * @Author: Twiss
 * @Date: 2022/6/22 2:44 下午
 */
public class MinFlow {

    public int getMin(int[][] grids){
        if (grids==null||grids.length==0){
            return 0;
        }
        int rows = grids.length, col = grids[0].length;
        int[][] dp = new int[rows][col];
        dp[0][0] = grids[0][0];
        int k =0;
        for (int i=1;i<rows;i++){
            if (grids[i][0]==grids[i-1][0]){
                k++;
            }
            dp[i][0] = dp[i-1][0]+grids[i][0]-k;
            k = 0;
        }
        for (int j=1;j<col;j++){
            if (grids[0][j]==grids[0][j-1]){
                k++;
            }
            dp[0][j] = dp[0][j-1]+grids[0][j]-k;
            k = 0;
        }
        int r=0,c=0;
        for (int i=1;i<rows;i++){
            for (int j =1;j<col;j++){
                if (grids[i-1][j]==grids[i][j]){
                    c++;
                }
                if (grids[i][j-1]==grids[i][j]){
                    r++;
                }
                if (grids[i-1][j-1]==grids[i][j]){
                    k++;
                }
                // 上下一致
                int rDp = dp[i-1][j]+grids[i][j]-c;
                // 左右一致
                int cDp = dp[i][j-1]+grids[i][j]-r;
                // 斜上一致
                int jDp = dp[i-1][j-1]+grids[i][j]-k;

                dp[i][j] = Math.min(rDp,Math.min(cDp,jDp));
                c = 0;
                r = 0;
                k = 0;
            }
        }
        return dp[rows-1][col-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grids = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                grids[i][j] = sc.nextInt();
            }
        }
        int ans = new MinFlow().getMin(grids);
        System.out.println(ans);
    }
}
