package com.twiss.shenxinfu;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2022/3/9 8:28 下午
 */
public class NcovDefect {

    private int[][] grid;
    private int m,n;
    public int getNumbersOfDefect(int[][] grids){
        this.grid = grids;
        this.n = grids.length;
        this.m = grids[0].length;
        int res = 0;
        for (int i =0;i<n;++i){
            for (int j=0;j<m;++j){
                if (grids[i][j]==1){
                    dfs(i,j);
                }
                if (grids[i][j]==2){
                    res++;
                }
            }
        }
        System.out.println(JSONObject.toJSONString(grids));
        return res;
    }

    private void dfs(int i,int j){
        if (!inAreas(i,j)){
            if (grid[i][j]==1){
                dfs(i-1,j);
                dfs(i,j-1);
                dfs(i+1,j);
                dfs(i,j+1);
            }
        }
    }

    private boolean inAreas(int i,int j){
        return i<0||j<0||i>=n||j>=m;
    }

    public static void main(String[] args) {
        int[][] nums ={
            {0,1,0,0,0,0,1},
            {0,1,0,0,0,0,1},
            {0,0,0,0,0,0,1},
            {0,0,0,0,0,0,0}
        };
        int res = new NcovDefect().getNumbersOfDefect(nums);
        System.out.println(res);
    }
}
