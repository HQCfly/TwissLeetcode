package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @Author: Twiss
 * @Date: 2022/7/24 6:52 下午
 */
public class SnakeGame {

    private static int m,n;
    private int maxLen;
    private Deque<int[]> visited;
    public int getBodyLength(String[] operation,String[][] grids,int x,int y){
        maxLen = 1;
        // 0表示向上 1表示下 2表示向左 3表示向右
        int direction = 0;
        visited = new ArrayDeque<>();
        visited.add(new int[]{x,y});
        for (int i=0;i<operation.length;i++){
            if ("U".equals(operation[i])){
                direction = 0;
            }else if ("D".equals(operation[i])){
                direction = 1;
            }else if ("L".equals(operation[i])){
                direction = 2;
            }else if ("R".equals(operation[i])){
                direction = 3;
            }else if ("G".equals(operation[i])){
                if (direction==0){
                    // 向上
                    int newX = x-1;
                    if (isGameOver(newX,y,grids)){
                        calculate(x,y,newX,y,grids);
                    }else {
                        break;
                    }
                    x = newX;
                }else if (direction==1){
                    // 向下
                    int newX = x+1;
                    if (isGameOver(newX,y,grids)){
                        calculate(x,y,newX,y,grids);
                    }else {
                        break;
                    }
                    x = newX;
                }else if (direction==2){
                    // 向左
                    int newY = y-1;
                    if (isGameOver(x,newY,grids)){
                        calculate(x,y,x,newY,grids);
                    }else {
                        break;
                    }
                    y = newY;
                }else {
                    // 向右
                    int newY = y+1;
                    if (isGameOver(x,newY,grids)){
                        calculate(x,y,x,newY,grids);
                    }else {
                        break;
                    }
                    y = newY;
                }
            }
        }
        return maxLen;
    }

    private void calculate(int x,int y,int newX,int newY,String[][] grids){
        if ("F".equals(grids[newX][newY])){
            grids[x][y] = "1";
            x = newX;
            y = newY;
            grids[x][y] = "H";
            visited.offer(new int[]{x,y});
            maxLen++;
        }else if ("E".equals(grids[x][newY])){
            if (!visited.isEmpty()){
                int[] last = visited.poll();
                int lastX = last[0];
                int lastY = last[1];
                grids[lastX][lastY] = "E";
                x = newX;
                y = newY;
                grids[x][y] = "H";
            }
        }
    }

    private boolean isGameOver(int i,int j,String[][] grids){
        // 边界+碰到身体
        return i<0||i>=m||j<0||j>=n||grids[i][j].equals("1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] operations = sc.nextLine().split(" ");
        m = sc.nextInt();
        n = sc.nextInt();
        String[][] grids = new String[m][n];
        sc.nextLine();
        int x=0;
        int y =0;
        for (int i=0;i<m;i++){
            String[] grid = sc.nextLine().split(" ");
            for (int j=0;j<n;j++){
                if (grid[j].equals("H")){
                    x = i;
                    y = j;
                }
                grids[i][j] = grid[j];
            }
        }
        int ans = new SnakeGame().getBodyLength(operations,grids,x,y);
        System.out.println(ans);
    }
}
