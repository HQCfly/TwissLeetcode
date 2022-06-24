package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 迷宫问题
 *
 * @Author: Twiss
 * @Date: 2022/6/24 2:45 下午
 */
public class MazeProblem2 {

    private static int n1;
    private static int m1;
    private static int[][] arr;//邻接表
    private static boolean[][] mark;
    private static int endX1;
    private static int endY1;
    private static List<int[]> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sa = sc.nextLine().split(" ");
        n1 = Integer.parseInt(sa[0]);
        m1 = Integer.parseInt(sa[1]);
        endX1 = n1 -1;
        endY1 = m1 -1;
        arr = new int[n1][m1];
        mark = new boolean[n1][m1];
        for (int i = 0; i < n1; i++) {
            String[] split = sc.nextLine().split(" ");
            for (int j = 0; j < m1; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }
        dfs(0, 0);
        Collections.reverse(path);
        for (int i = 0; i < path.size(); i++) {
            int[] res = path.get(i);
            System.out.println("(" + res[0] + "," +res[1]+ ")");
        }
    }
    //dfs就是递归求最小值
    private static boolean dfs(int x1,int y1){
        if (x1 == endX1 && y1 == endY1){
            path.add(new int[]{x1,y1});
            return true;
        }
        int[][] next = {{1,0},{0,1},{0,-1},{-1,0}};
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nextX = x1 + next[i][0];
            int nextY = y1 + next[i][1];
            if (nextX < 0 || nextX >= n1 || nextY<0 || nextY>= m1){
                continue;
            }
            if (arr[nextX][nextY] == 0 && !mark[nextX][nextY]){//下个点是0 且未做标记
                mark[nextX][nextY] = true;
                if (dfs(nextX, nextY)) {
                    flag = true;
                    path.add(new int[]{x1,y1});
                }
                mark[nextX][nextY] = false;
            }
        }
        return flag;
    }
}
