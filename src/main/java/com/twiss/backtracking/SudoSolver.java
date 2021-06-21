package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/6/10 11:00 下午
 */
public class SudoSolver {


    public void solveSudoku(char[][] board) {

        if (board == null || board.length != 9 || board[0].length != 9) return;

        // 3个布尔数组 表明行 列 还有 3 * 3 的方格的数字是否被使用过
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        // 初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        // 递归尝试填充数组
        dfs(board,0, row, col, box);
    }

    public boolean dfs(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        // 边界校验，如果填充完成返回true，都在false
        if (n==81){
            return true;
        }
        // i表示行，j表示列
        int i = n/9, j = n%9;
        // 如果第i行j列是.则表示可以填充
        if (board[i][j] != '.') return dfs(board, n + 1, row, col, box);
        // 3*3数字方格
        int k = (i / 3) * 3 + j / 3;
        for (int num=0;num<9;num++){
            if (row[i][num]||col[j][num]||box[k][num]){
                continue;
            }
            board[i][j] = (char) ('1'+num);
            row[i][num]=col[j][num]=box[k][num]=true;
            if (dfs(board,n+1,row,col,box)){
                return true;
            }
            row[i][num]=col[j][num]=box[k][num]=false;
        }
        board[i][j] = '.';
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        SudoSolver sudoSolver = new SudoSolver();
        sudoSolver.solveSudoku(board);
        System.out.println(JSONObject.toJSONString(board));
    }
}
