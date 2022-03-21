package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode-solution/
 * n皇后II方案数
 * @Author: Twiss
 * @Date: 2021/5/23 9:08 下午
 */
public class NQueensII {
    public int count = 0;

    private int solveQueens(int n) {
        List<String[]> res = new ArrayList<>();
        int[] columnRow = new int[n];
        backtrace(n, 0, columnRow);
        return count;
    }

    private void backtrace(int n, int row, int[] columnRow) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            columnRow[row] = i;
            if (!isValid(i, row, columnRow)) {
                continue;
            }
            backtrace(n, row + 1, columnRow);
        }
    }

    private boolean isValid(int col, int row, int[] columnRow) {
        for (int r = 0; r < row; r++) {
            // |行标-列标| == |边界行-边界列|
            if (columnRow[r] == col || row - r == Math.abs(columnRow[r] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int res2 = new NQueensII().solveQueens(n);
        System.out.println(res2);
    }
}
