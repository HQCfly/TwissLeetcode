package com.twiss.microsoft;

/**
 * @Author: Twiss
 * @Date: 2022/1/19 11:24 下午
 */
public class TheNumbersOfIsland {

    public int getNumberOfIsland(int[][] grids){
        int row = grids.length, col = grids[0].length;
        int res = 0;
        for (int i=0;i<row;++i){
            for (int j = 0;j<col;++j){
                if (grids[i][j]==1){
                    dfs(grids,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grids, int r, int c){
        // 超出网格范围或者当前节点值不等于1则返回
        if (!inArea(grids,r,c)||grids[r][c]!=1){
            return;
        }
        // 将遍历过的点设置为2，表示已经遍历过
        grids[r][c] = 2;
        // 当前点的上一行节点
        dfs(grids,r-1,c);
        // 当前点的下一行节点
        dfs(grids,r+1,c);
        // 当前点的同行前一列节点
        dfs(grids,r,c-1);
        // 当前点的同行后一列节点
        dfs(grids,r,c+1);
    }

    private boolean inArea(int[][] grids, int r,int c){
        return 0<=r&&r<grids.length
                &&0<=c&&c<grids[1].length;
    }

    public static void main(String[] args) {
        int[][] grids = {
                {1,1,1,1,0},
                {1,1,0,0,0},
                {1,1,0,1,0},
                {0,1,0,0,0},
        };
        int res = new TheNumbersOfIsland().getNumberOfIsland(grids);
        System.out.println(res);
    }
}
