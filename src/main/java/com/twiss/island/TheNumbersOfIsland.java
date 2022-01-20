package com.twiss.island;

/**
 * @Author: Twiss
 * @Date: 2022/1/20 2:54 下午
 */
public class TheNumbersOfIsland {

    public int getNumbers(int[][] grids){
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
        if (!inArea(grids,i,j)||grids[i][j]!=1){
            return;
        }
        grids[i][j] = 2;
        dfs(grids,i-1,j);
        dfs(grids,i+1,j);
        dfs(grids,i,j-1);
        dfs(grids,i,j+1);
    }

    private boolean inArea(int[][] grids, int i,int j){
        return 0<=i&&i< grids.length&&
                0<=j&&j<grids[0].length;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {1,1,0,1,0},
                {0,1,0,0,0},
        };
        int res = new TheNumbersOfIsland().getNumbers(grids);
        System.out.println(res);
    }
}
