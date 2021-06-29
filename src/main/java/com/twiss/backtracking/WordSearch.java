package com.twiss.backtracking;

/**
 * @Author: Twiss
 * @Date: 2021/6/29 7:15 下午
 */
public class WordSearch {

    private boolean exist(char[][] grid, String word) {
        int h = grid.length, k = grid[0].length;
        boolean visited[][] = new boolean[h][k];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < k; j++) {
                if (check(grid,word,visited,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] grid, String word, boolean[][] visited, int i,int j,int k) {
        // 判断grid[i][j]是否与word[k]
        if (grid[i][j]!=word.charAt(k)){
            return false;
        }

        if (k==word.length()-1){
            return true;
        }
        visited[i][j] = true;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};

        boolean result = false;

        for (int[] dir:direction){
            int newI = i+dir[0], newJ = j+dir[1];
            if (newI>=0&&newI< grid.length&&newJ>=0&&newJ<grid[0].length){
                if (!visited[newI][newJ]){
                    boolean flag = check(grid,word,visited,newI,newJ,k+1);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean res = new WordSearch().exist(grid, word);
        System.out.println(res);
    }
}
