package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/23 9:08 下午
 */
public class NQueens {

    private List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chessBoard = new char[n][n];
        for (char[] line : chessBoard) {
            Arrays.fill(line, '.');
        }
        backtrace(chessBoard, n, 0, res);
        return res;
    }

    private void backtrace(char[][] chessBoard, int n, int row, List<List<String>> res) {
        if (row == n) {
            List<String> copyBoard = new ArrayList<>();
            for (char[] line : chessBoard) {
                copyBoard.add(String.valueOf(line));
            }
            res.add(copyBoard);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(n,i, row, chessBoard)) {
                continue;
            }
            chessBoard[row][i] = 'Q';
            backtrace(chessBoard, n, row + 1, res);
            chessBoard[row][i] = '.';
        }
    }

    private boolean isValid(int n,int col,int row, char[][] chessboard) {
        //判断列是否存在皇后
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col] == 'Q')
                return false;
        }

        //判断右上方（斜线）是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q')
                return false;
        }

        //判断左上方（斜线）是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chessboard[i][j] == 'Q')
                return false;

        //到此说明皇后落子合格
        return true;
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = new NQueens().solveNQueens(n);
        System.out.println(JSONObject.toJSONString(res));
    }
}
