package com.twiss.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 给定一个N*M的数组arr，代表N*M个方格组成的版图，贪吃蛇每次移动一个方格。
 * 若arr[i][j] == ‘H’，表示该方格为贪吃蛇的起始位置；
 * 若arr[i][j] == ‘F’，表示该方格为食物，
 * 若arr[i][j] == ‘E’，表示该方格为空格。
 * 贪吃蛇初始长度为1，初始移动方向为向左。
 * 为给定一系列贪吃蛇的移动操作，返回操作后蛇的长度，如果在操作执行完之前已经游戏结束，返回游戏结束时蛇的长度。
 */
public class Snake {

    // 走过的路径用坐标记录,去重
    static Deque<int[]> path = new ArrayDeque<>();
    static int totalLen = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 操作
            String[] operations = scanner.nextLine().split(" ");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int startRow = -1, startCol = -1;
            String[][] strings = new String[rows][cols];
            // 构建数组
            scanner.nextLine();
            for (int i = 0; i < rows; i++) {
                String[] cur = scanner.nextLine().split(" ");
                for (int j = 0; j < cols; j++) {
                    strings[i][j] = cur[j];
                    if (strings[i][j].equals("H")) {
                        startRow = i;
                        startCol = j;
                        path.addLast(new int[]{startRow, startCol});
                    }
                }
            }
            simulating(startRow, startCol, rows, cols, operations, strings, 0);
            System.out.println("totalLen:"+totalLen);
        }
    }

    private static void simulating(int curRow, int curCol, int totalRow, int totalCol, String[] operations, String[][] form, int index) {
        int[] temp = new int[]{curRow, curCol};
        // 越界或者违规
        if (curCol < 0 || curRow < 0 || curCol >= totalRow || curRow >= totalRow || path.contains(temp)) {
            return;
        }
        // 贪吃蛇吃到食物
        if (form[curRow][curCol].equals("F")) {
            totalLen++;
            path.addFirst(new int[]{curRow, curCol});
        } else if (form[curRow][curCol].equals("E")) {
            // 踩到空格
            path.pollLast();
            path.addFirst(new int[]{curRow, curCol});
        }
        // 执行完毕
        if (index >= operations.length) return;
        // 向下进行模拟
        if (operations[index].equals("L")) {
            simulating(curRow, curCol - 1, totalRow, totalCol, operations, form, index + 1);
        } else if (operations[index].equals("D")) {
            simulating(curRow + 1, curCol, totalRow, totalCol, operations, form, index + 1);
        } else if (operations[index].equals("R")) {
            simulating(curRow, curCol + 1, totalRow, totalCol, operations, form, index + 1);
        } else if (operations[index].equals("U")) {
            simulating(curRow - 1, curCol, totalRow, totalCol, operations, form, index + 1);
        }
    }
}
