package com.twiss.zijie;

/**
 * 岛屿数量
 * @Author: Twiss
 * @Date: 2022/4/23 9:24 下午
 */
public class TheNumberOfIslands {

    public int getNumber(int[][] grids){
        int res = 0;
        for (int i=0;i<grids.length;++i){
            for (int j=0;j<grids[0].length;++j){
                if (grids[i][j]==1){
                    dfs(grids,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grids, int i,int j){
        if (!isArea(grids,i,j)){
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

    private boolean isArea(int[][] grids,int i,int j){
        return i>=0&&i<grids.length&&j>=0&&j<grids[0].length;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,1,0},
        };
        int res = new TheNumberOfIslands().getNumber(grids);
        System.out.println(res);
    }
}
