package com.twiss.huawei;

import java.util.Scanner;

/**
 * 迪杰斯特拉算法解决最小时延
 *
 * @Author: Twiss
 * @Date: 2022/6/23 3:13 下午
 */
public class Dijkstra {

    private final int INF = Integer.MAX_VALUE;

    public int getMinDistance(int n,int[][] matrix, int vs, int end) {
        if (n==0||matrix==null||matrix.length==0){
            return 0;
        }
        // 表示"顶点vs"到"顶点i"的最短路径已成功获
        boolean[] flag = new boolean[n];
        // 前驱节点表
        int[] prev = new int[n];
        // 起点到i节点的距离表
        int[] dis = new int[n];
        // 初始化
        for (int i=0;i<n;i++){
            flag[i] = false;
            prev[i] = 0;
            dis[i] = matrix[vs][i];
        }
        flag[vs] = true;
        dis[vs] = 0;

        // 遍历n次；每次找出一个顶点的最短路径。
        int k = 0;
        for (int i=1;i<n;i++){
            // 第一次寻找最短距离节点
            int min = INF;
            for (int j=0;j<n;j++){
                if (!flag[j] &&dis[j]<min){
                    min = dis[j];
                    k = j;
                }
            }
            flag[k] = true;
            // 修正U集合里面的顶点距离
            for (int j=0;j<n;j++){
                int tmp = matrix[k][j]==INF?INF:(min+matrix[k][j]);
                if (!flag[j]&&tmp<dis[j]){
                    dis[j] = tmp;
                    prev[j] = k;
                }
            }
        }
        return dis[end];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i=0;i<m;i++){
                int row = sc.nextInt();
                int col = sc.nextInt();
                matrix[col-1][row-1] = matrix[row-1][col-1] = sc.nextInt();
            }
            int vs = sc.nextInt();
            int end = sc.nextInt();
            int ans = new Dijkstra().getMinDistance(n,matrix,vs-1,end-1);
            System.out.println(ans);
        }
    }
}
