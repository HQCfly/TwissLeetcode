package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题
 *
 * @Author: Twiss
 * @Date: 2022/6/24 2:45 下午
 */
public class MazeProblem {

    private boolean[][] mark;
    private int m, n;
    private List<List<Integer>> path;

    public List<List<Integer>> getPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        m = matrix.length;
        n = matrix[0].length;
        mark = new boolean[m][n];
        List<List<Integer>> path = new ArrayList<>();
        dfs(matrix, 0, 0);
        return path;
    }

    private boolean dfs(int[][] matrix, int x, int y) {
        if (x == m-1 && y == n-1) {
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            path.add(new ArrayList<>(list));
            return true;
        }
        boolean flag = false;
        // 每次都要在各个路径上搜索到底，如果发现此路不通则，则向上返回
        // 表示上下左右
        int[][] direction = {{1,0},{0,1},{0,-1},{-1,0}};
        for (int i = 0; i < 4; i++) {
            int newX = direction[i][0] + x;
            int newY = direction[i][1] + y;
            // 超出范围或者遇到路障则返回，表示此路不通
            if (newX < 0 || newX >= m-1 || newY<0 || newY>= n-1){
                continue;
            }
            // 如果迷宫格是0，表示可走
            if (matrix[newX][newY] == 0 && !mark[newX][newY]){//下个点是0 且未做标记
                mark[newX][newY] = true;
                if (dfs(matrix,newX, newY)) {
                    flag = true;
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    list.add(y);
                    path.add(new ArrayList<>(list));
                }
                mark[newX][newY] = false;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
//            int m = sc.nextInt();
//            int n = sc.nextInt();
//            int[][] matrix = new int[m][n];
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    matrix[i][j] = sc.nextInt();
//                }
//            }
            int[][] matrix = {
                    {0,1,0,0,0},
                    {0,1,1,1,0},
                    {0,0,0,0,0},
                    {0,1,1,1,0},
                    {0,0,0,1,0},
            };
            List<List<Integer>> ans = new MazeProblem().getPath(matrix);
            System.out.println(JSONObject.toJSONString(ans));
        }
    }
}
