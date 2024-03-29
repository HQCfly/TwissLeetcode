package com.twiss.microsoftII;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/solution/zui-xiao-lu-jing-he-by-leetcode-solution/
 * 最小路径和
 * 时间复杂度O(mn)
 * 空间复杂度O(mn)
 * @Author: Twiss
 * @Date: 2022/3/24 1:54 下午
 */
public class MinPathSum {

    public int getMin(int[][] grid){
        if (grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i=1;i<row;++i){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int j=1;j<col;++j){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }

        for (int i=1;i<row;++i){
            for (int j=1;j<col;++j){
                // 先选择左边或者上面最小的值，然后再加当前元素
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int ans = new MinPathSum().getMin(grid);
        System.out.println(ans);
    }
}
