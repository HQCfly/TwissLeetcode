package com.twiss.shopee;

/**
 * N皇后方案数
 * @Author: Twiss
 * @Date: 2022/3/22 9:38 下午
 */
public class NQueenII {
    private int count=0;

    public int getNumbersOfPlan(int n){
        int[] columnRow = new int[n];
        backtrace(n, 0, columnRow);
        return count;
    }

    private void backtrace(int n,int row,int[] columnRow){
        if (row==n){
            count++;
            return;
        }

        for (int i=0;i<n;++i){
            // 每次以row行i列作为皇后第一个落子点
            columnRow[row] = i;
            if (!isValid(i,row,columnRow)){
                continue;
            }
            backtrace(n,row+1,columnRow);
        }
    }

    private boolean isValid(int col, int row, int[] columnRow){
        // r < row表示不会同行去遍历
        for (int r=0;r<row;r++){
            // 同行同列的返回false或者对角线的false：
            // columnRow[r] == col 表示同列了
            // row-r = Math.abs(columnRow[r]-col)表示对角线
            if (columnRow[r] == col || row-r == Math.abs(columnRow[r]-col)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int ans = new NQueenII().getNumbersOfPlan(n);
        System.out.println(ans);
    }
}
