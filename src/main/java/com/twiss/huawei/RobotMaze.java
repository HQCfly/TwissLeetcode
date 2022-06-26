package com.twiss.huawei;

import java.util.Scanner;

/**
 * 机器人走迷宫
 * @Author: Twiss
 * @Date: 2022/6/26 10:25 下午
 */
public class RobotMaze {

    private static int m1;
    private static int n1;
    private static int endX;
    private static int endY;
    private static int[][] arr;
    private static boolean[][] mark;
    private static int trip = 0;

    public void getTripsAndUnReach(int x1, int y1){
        arr[x1][y1] = 2;//初始化点位
        dfs(x1, y1);
        //遍历所有坐标 结果是0的就是A(UnReach)
        int unReach = 0;
        for (int i=0;i<m1;i++){
            for (int j=0;j<n1;j++){
                if (arr[i][j]==0){
                    unReach++;
                    System.out.println(i+":"+j);
                }
            }
        }
        System.out.println(trip+" "+unReach);
    }

    private boolean dfs(int x1,int y1){
        boolean flag = false;
        if (x1==endX&&y1==endY){
            return true;
        }

        int[][] dir = {{-1,0},{0,1}};
        for (int i=0;i<2;i++){
            int newX1 = x1+dir[i][0];
            int newY1 = y1+dir[i][1];
            // 避免超出范围
            if (newX1<0||newY1>=n1){
                continue;
            }
            if (arr[newX1][newY1]!=1&&mark[newX1][newY1]){
                mark[newX1][newY1] = true;
                arr[newX1][newY1] = 2;//表示当前点已经走过
                if (dfs(newX1,newX1)){
                    flag = true;
                }
                mark[newX1][newY1] = false;
            }
        }
        if (!flag){
            trip++;
            System.out.println(x1+" "+y1);
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nms = sc.nextLine().split(" ");
        n1 = Integer.parseInt(nms[1]);
        m1 = Integer.parseInt(nms[0]);
        arr = new int[n1][m1];
        mark = new boolean[n1][m1];
        int x1 = n1 - 1;
        int y1 = 0;
        endX = 0;
        endY = m1 - 1;
        int wellCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < wellCount; i++) {
            String[] wall = sc.nextLine().split(" ");
            int weX1 = n1 -1 - Integer.parseInt(wall[1]);
            int weY1 = Integer.parseInt(wall[0]);
            arr[weX1][weY1] = 1;
        }
    }
}
