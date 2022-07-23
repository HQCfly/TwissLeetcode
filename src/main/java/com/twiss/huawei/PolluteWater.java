package com.twiss.huawei;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 污染水域
 * @Author: Twiss
 * @Date: 2022/7/23 7:15 下午
 */
public class PolluteWater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int N = (int) Math.sqrt(s.length);
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(s[j + i * N]);
            }
        }
        // 图的多源BFS
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        // 将所有污染源都入队
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        // 全部被无污染或者永远无法被污染
        if (queue.size() == 0 || queue.size() == N * N) {
            System.out.println(-1);
            return;
        }
        // 从各个污染源开始，一圈圈遍历
        int[] node = null;  // 定义到循环外面，方便输出结果
        while (!queue.isEmpty()){
            node = queue.poll();
            int x = node[0], y = node[1];
            for (int i = 0; i < 4; i++) {  // 上下左右扩散
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 越界或者不是净水
                if (newX < 0 || newX >= N || newY < 0 || newY >= N || grid[newX][newY] != 0) {
                    continue;
                }
                // 直接修改原数组，把污染源改为净水
                grid[newX][newY] = grid[x][y] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        // 返回最后一次遍历到净水的天数 - 1，或者输出当前数组的最大值-1
        System.out.println(grid[node[0]][node[1]] - 1);
    }
}
