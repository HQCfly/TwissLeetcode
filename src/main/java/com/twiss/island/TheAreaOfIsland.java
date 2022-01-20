package com.twiss.island;

/**
 * @Author: Twiss
 * @Date: 2022/1/20 3:04 下午
 */
public class TheAreaOfIsland {

    public int getArea(int[][] grids){
        int res = 0;
        for (int r = 0; r < grids.length; r++) {
            for (int c = 0; c < grids[0].length; c++) {
                if (grids[r][c] == 1) {
                    int a = dfs(grids, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grids, int i,int j){
        if (!inArea(grids,i,j)||grids[i][j]!=1){
            return 0;
        }
        grids[i][j] = 2;
        return 1+dfs(grids,i+1,j)+
                dfs(grids,i-1,j)+
                dfs(grids,i,j-1)+
                dfs(grids,i,j+1);
    }

    private boolean inArea(int[][] grids, int i,int j){
        return 0<=i&&i<grids.length&&
                0<=j&&j<grids[0].length;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,1,0,0,0},
        };
        int area = new TheAreaOfIsland().getArea(grids);
        System.out.println(area);
    }
}
