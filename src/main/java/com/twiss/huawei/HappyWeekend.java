package com.twiss.huawei;

import java.util.Scanner;

/**
 * 欢乐周末
 * @Author: Twiss
 * @Date: 2022/6/27 11:14 下午
 */
public class HappyWeekend {

    private static int m, n;
    private static int[][] grids;
    private static boolean[][] mark;

    private static boolean dfs(int x1,int y1, int endX1, int endY1){
        boolean flag = false;
        if (x1==endX1&&y1==endY1){
            return true;
        }

        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i=0;i<direct.length;i++){
            int nextX = x1+direct[i][0];
            int nextY = x1+direct[i][1];
            // 边界处理
            if (nextX<0||nextX>=m||nextY<0||nextY>=n){
                continue;
            }
            if (grids[nextX][nextY]!=1&&!mark[nextX][nextY]){
                mark[nextX][nextY] = true;
                if (dfs(nextX,nextY,endX1,endY1)){
                    flag = true;
                }
                mark[nextX][nextY] = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            m = sc.nextInt();
            n = sc.nextInt();
            grids = new int[m][n];
            mark = new boolean[m][n];
            int[][] start = new int[2][2];
            int[][] end = new int[m][2];
            int index = 0, endIndex = 0;
            for (int i=0;i<m;i++){
                for (int j=0;j<n;j++){
                    grids[i][j] = sc.nextInt();
                    if (grids[i][j]==2){
                        start[index][0] = i;
                        start[index][1] = j;
                        index++;
                    }else if (grids[i][j]==3){
                        end[endIndex][0] = i;
                        end[endIndex][1] = j;
                        endIndex++;
                    }
                }
            }
            int count = 0;
            if (endIndex>1){
                for (int i=0;i<endIndex;i++){
                    boolean hua = dfs(start[0][0],start[0][1],end[i][0],end[i][1]);
                    boolean wei = dfs(start[1][0],start[1][1],end[i][0],end[i][1]);
                    if (hua==wei){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
