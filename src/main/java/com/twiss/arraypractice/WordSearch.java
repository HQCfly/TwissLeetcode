package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/5/2 7:54 下午
 */
public class WordSearch {

    public static boolean exist(char[][] grid, String word) {
        int h = grid.length, k = grid[0].length;
        boolean[][] visited = new boolean[h][k];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < k; ++j) {
                if (check(grid, visited, i, j, word, k)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean check(char[][] grid, boolean[][] visited, int i, int j, String word, int k) {
        // 判断该位置的字母是否与 目标单词中的k字母相等
        if (grid[i][j] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            // 已找到全部相等
            return true;
        }
        // 设置该位置为已访问
        visited[i][j] = true;
        // 与i，j相邻的上下左右位置
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        // 在四个位置寻找能与目标单词一样的单词
        for (int[] dir : direction) {
            int newI = i + dir[0], newJ = j + dir[1];
            if (newI > 0 && newI < grid.length && newJ > 0 && newJ < grid[0].length) {
                if (!visited[newI][newJ]){
                    boolean flag = check(grid,visited,newI,newJ,word,k+1);
                    if (flag){
                        result = true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        boolean res = exist(grid,word);
        System.out.println(res);
    }
}
