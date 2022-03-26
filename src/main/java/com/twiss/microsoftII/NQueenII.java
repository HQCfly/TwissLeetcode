package com.twiss.microsoftII;

/**
 * N皇后解决方案
 * 时间复杂度O(nlogn)
 * 时间复杂度O(logn)
 * @Author: Twiss
 * @Date: 2022/3/24 1:54 下午
 */
public class NQueenII {

    private int count;
    public int getNumbersOfPlan(int n){
        int[] columnRow = new int[n];
        backtrace(n,columnRow,0);
        return count;
    }

    private void backtrace(int n,int[] columnRow, int row){
        if (row==n){
            count++;
            return;
        }

        for (int i=0;i<n;++i){
            // 每次以row行i列作为皇后第一个落子点
            columnRow[row] = i;
            if (!isValid(i,columnRow,row)){
                continue;
            }
            backtrace(n,columnRow,row+1);
        }
    }

    private boolean isValid(int col,int[] columnRow, int row){
        for (int r=0;r<row;++r){
            if (columnRow[r]==col||row-r==Math.abs(columnRow[r]-col)){
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
