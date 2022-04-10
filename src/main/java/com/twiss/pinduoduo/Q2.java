package com.twiss.pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/4/10 7:50 下午
 */
public class Q2 {

    // 求最少走的步数
    public static int getTravel(int startRow, int startCol, int[][] board){
        // 对应能够走的方向
        int[] move1= {-2,-1,1,2,2,1,-1,-2};
        int[] move2= {1,2,2,1,-1,-2,-2,-1};

        // 下一个出路的位置
        int[] next1 = new int[board.length];
        int[] next2 = new int[board.length];

        // 出路的个数
        int[] exists = new int[board.length];

        int x = startRow;
        int y = startCol;

        board[x][y] = 1;

        int count = 0;
        for (int i=2;i<=Math.pow(board.length, 2);++i){
            for (int j=0;j< board.length;++j){
                exists[j] = 0;
            }
            // 试探八个方向
            for (int j = 0;j<board.length;++j){
                int tmpi = x+move1[j];
                int tmpj = y+move2[j];

                // 判断是否是边界
                if (tmpi<0||tmpj<0||tmpi>7||tmpj>7){
                    continue;
                }

                // 判断是否是障碍
                if ((x>1&&board[x-1][y]==0&&(tmpi+1==x-1&&tmpj+1==y))||
                        (y>1&&board[x][y-1]==0&&(tmpi+1==x-1&&tmpj+1==y))||
                        (x+1< board.length&&board[x+1][y]==0)||
                        (y+1<board[0].length&&board[x][y+1]==0)){
                    continue;
                }

                // 方向可走
                if (board[tmpi][tmpj]==1){
                    next1[count] = tmpi;
                    next2[count] = tmpj;
                    // 可走方案加1
                    count++;
                }
            }

            int min = -1;
            if (count==1){
                min = 0;
            }else {
                // 找出下一个位置的出路
                for (int k=0;k<count;++k){
                    for (int j = 0;j<board.length;++j){
                        int tmpi = next1[k]+move1[j];
                        int tmpj = next2[k]+move2[j];

                        // 判断是否是边界
                        if (tmpi<0||tmpj<0||tmpi>7||tmpj>7){
                            continue;
                        }

                        // 方向可走
                        if (board[tmpi][tmpj]==0){
                            exists[i]++;
                        }
                    }
                }
                int tmp = exists[0];
                min = 0;
                // 从可走的路中寻找最少步
                for (int l=1;l<count;++l){
                    if(exists[l]<tmp){
                        tmp = exists[l];
                        min = l;
                    }
                }
            }
            // 最少出路方向
            x = next1[min];
            y = next2[min];
            board[x][y] = min;
        }
        return board[x][y];
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int testNumbers = in.nextInt();
            List<Integer> ans = new ArrayList<>();
            for (int i=0;i<testNumbers;++i){
                int row = in.nextInt();
                int col = in.nextInt();
                // 2表示起点，3表示终点
                int[][] board = new int[row][col];
                int startR = 0;
                int startC = 0;
                for (int rowInx = 0;rowInx<row;++rowInx){
                    for (int colInx =0;colInx<col;++colInx){
                        String bo = in.nextLine();
                        if ("K".equals(bo)){
                            board[rowInx][colInx] = 2;
                            startR = rowInx;
                            startC = colInx;
                        }else if ("T".equals(bo)){
                            board[rowInx][colInx] = 3;
                        }else if ("1".equals(bo)){
                            board[rowInx][colInx] = 1;
                        }else if ("0".equals(bo)){
                            board[rowInx][colInx] = 0;
                        }else {
                            System.exit(-1);
                        }
                    }
                }
                // 获取最少步数
                ans.add(getTravel(startR,startC,board));
            }
            for (int i:ans){
                System.out.println(i);
            }
        }

    }
}










