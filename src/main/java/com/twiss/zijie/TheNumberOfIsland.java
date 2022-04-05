package com.twiss.zijie;

/**
 * 岛屿数量
 * dfs
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/4/5 8:59 下午
 */
public class TheNumberOfIsland {

    public int getNumber(int[][] grids){
        int n = grids.length;
        int m = grids[0].length;
        int nums = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grids[i][j]==1){
                    dfs(grids,i,j);
                    nums++;
                }
            }
        }
        return nums;
    }

    private void dfs(int[][] grids,int i,int j){
        if (!inArea(grids,i,j)){
            return;
        }
        if (grids[i][j]!=1){
            return;
        }

        grids[i][j]=2;
        dfs(grids,i-1,j);
        dfs(grids,i+1,j);
        dfs(grids,i,j-1);
        dfs(grids,i,j+1);
    }

    private boolean inArea(int[][] grids, int i,int j){
        return 0<=i&&i<grids.length&&0<=j&&j<grids[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {1,1,0,1,0},
                {0,0,0,0,0}
        };
        int ans = new TheNumberOfIsland().getNumber(grid);
        System.out.println(ans);
    }
}
