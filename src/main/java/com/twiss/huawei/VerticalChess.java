package com.twiss.huawei;

import java.util.Scanner;

/**
 * 竖直四子棋
 *
 * @Author: Twiss
 * @Date: 2022/6/22 12:02 下午
 */
public class VerticalChess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int rowLen = Integer.parseInt(nums[0]);
        int colLen = Integer.parseInt(nums[1]);
        String[] str = sc.nextLine().split(" ");
        int[][] grids = new int[rowLen][colLen];
        boolean isOver = false;
        for (int i = 0; i < str.length; i++) {
            int index = -1;
            int color = 1;
            int num = Integer.parseInt(str[i]);
            // 判断是否合法: 落子点在棋盘范围之外或者落子点已经有棋
            if (num <= 0 || num > colLen || grids[0][num - 1] != 0) {
                isOver = true;
                System.out.println(i + 1 + ",error");
                break;
            }
            // 判断落子的是哪个颜色，1默认表示为red，2为blue
            if (i % 2 != 0) {
                color = 2;
            }
            // 落子到对应的位置
            for (int j = rowLen - 1; j >= 0; j--) {
                if (grids[j][num - 1] == 0) {
                    index = j; // 此时棋子横坐标为j，纵坐标为num-1
                    grids[j][num - 1] = color;
                    break;
                }
            }
            // 判断index是否合法
            if (index == -1) {
                System.out.println(i + 1 + ",error");
                isOver = true;
                break;
            }
            // 判断棋子是否超过6，并且判断是否能连接4个棋子
            if (i >= 6 && isSuccess(grids, index, num - 1)) {
                if (color == 1) {
                    System.out.println(i + 1 + ",red");
                    isOver = true;
                    break;
                } else {
                    System.out.println(i + 1 + ",blue");
                    isOver = true;
                    break;
                }
            }
        }
        // 判断是否已满
        if (!isOver) {
            System.out.println("0,draw");
        }
    }

    private static boolean isSuccess(int[][] grids, int row, int col) {
        int m = grids.length;
        int n = grids[0].length;
        int count = 0;
        int statist = 3; //统计棋子相连数量
        // 横向右相连
        if (col < n - 3) {
            int r = row;
            int c = col;
            while (statist != 0 && grids[r][++c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }
        // 横向左相连
        if (col>=3){
            int r = row;
            int c = col;
            while (statist != 0 && grids[r][--c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }
        // 纵向向下相连
        if (row<m-3){
            int r = row;
            int c = col;
            while (statist != 0 && grids[++r][c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }
        // 纵向向上相连
        if (row>=3){
            int r = row;
            int c = col;
            while (statist != 0 && grids[--r][c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }

        // 左斜相连
        if (row<m-3&&col>=3){
            int r = row;
            int c = col;
            while (statist != 0 && grids[++r][--c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }

        // 右斜相连
        if (row<m-3&&col<n-3){
            int r = row;
            int c = col;
            while (statist != 0 && grids[++r][++c] == grids[r][c]) {
                count++;
                statist--;
            }
            if (count == 3) {
                return true;
            }
            count = 0;
            statist = 3;
        }
        return false;
    }
}
