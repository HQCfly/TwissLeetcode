package com.twiss.zijie;

/**
 * 单词搜索
 * DFS
 * @Author: Twiss
 * @Date: 2022/4/17 5:59 下午
 */
public class WordSearch {

    public boolean exist(char[][] board, String word){
        for (int i=0;i<board.length;++i){
            for (int j=0;j<board[0].length;j++){
                return dfs(board,word,0,i,j);
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word,int current, int x,int y){
        if (board[x][y]!=word.charAt(current)){
            return false;
        }
        if (current==word.length()-1){
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '.';
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for (int i=0;i<4;i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if (newX<0||newX>=board.length||newY<0||newY>=board[0].length||board[newX][newY]=='.'){
                continue;
            }
            if (dfs(board,word,current+1,newX,newY)){
                return true;
            }
        }
        board[x][y] = tmp;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean ans = new WordSearch().exist(board,word);
        System.out.println(ans);
    }
}
