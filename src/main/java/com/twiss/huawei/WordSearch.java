package com.twiss.huawei;

import java.util.Scanner;

/**
 * 单词搜素
 * @Author: Twiss
 * @Date: 2022/7/23 11:19 上午
 */
public class WordSearch {

    public static int m,n;
    public static boolean find;
    public static void dfs(int i,int j,char[][] board, String word, boolean[][] visited,int pos){
        if (i<0||i>=m||j<0||j>=n||visited[i][j]||find||board[i][j]!=word.charAt(pos)){
            return;
        }
        if (pos==word.length()-1){
            find = true;
            return;
        }
        visited[i][j] = true;
        dfs(i+1,j,board,word,visited,pos+1);
        dfs(i,j+1,board,word,visited,pos+1);
        dfs(i-1,j,board,word,visited,pos+1);
        dfs(i,j-1,board,word,visited,pos+1);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();
        String word = sc.nextLine();
        System.out.println("word:"+word);
        char[][] board = new char[m][n];
        for (int i=0;i<m;i++){
            String str = sc.nextLine();
            System.out.println(str);
            for (int j=0;j<n;j++){
                board[i][j] = str.charAt(j);
            }
        }

        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (board[i][j] == word.charAt(0)) {
                    dfs(i, j, board, word, visited, 0);
                    if (find) {
                        System.out.print(i + 1);
                        System.out.print(" ");
                        System.out.print(j + 1);
                        return;
                    }
                }
            }
        }
    }
}
