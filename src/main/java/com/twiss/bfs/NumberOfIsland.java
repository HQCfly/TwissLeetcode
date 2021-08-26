package com.twiss.bfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2021/8/26 5:46 下午
 */
public class NumberOfIsland {

    public int getNumIsland(char[][] grid){
        if (grid==null||grid.length==0){
            return 0;
        }

        int nRow = grid.length;
        int nCol = grid[0].length;
        int numberIsland = 0;

        for (int i=0;i<nRow;i++){
            for (int j=0;j<nCol;j++){
                if (grid[i][j]=='1'){
                    ++numberIsland;
                    grid[i][j]='0';
                    Deque<Integer> deque = new LinkedList<>();
                    deque.offer(i*nCol+j);
                    while (!deque.isEmpty()){
                        int leve = deque.poll();
                        int dequeRow = leve / nCol;
                        int dequeCol = leve % nCol;
                        if (dequeRow-1>=0&&grid[dequeRow-1][dequeCol]=='1'){
                            deque.offer((dequeRow-1)*nCol+dequeCol);
                            grid[dequeRow-1][dequeCol]='0';
                        }
                        if (dequeRow+1<=nRow&&grid[dequeRow+1][dequeCol]=='1'){
                            deque.offer((dequeRow+1)*nCol+dequeCol);
                            grid[dequeRow+1][dequeCol]='0';
                        }
                        if (dequeCol-1>=0&&grid[dequeRow][dequeCol-1]=='1'){
                            deque.offer(dequeRow*nCol+dequeCol-1);
                            grid[dequeRow][dequeCol-1]='0';
                        }
                        if (dequeRow+1<=nCol&&grid[dequeRow][dequeCol+1]=='1'){
                            deque.offer(dequeRow*nCol+dequeCol+1);
                            grid[dequeRow][dequeCol+1]='0';
                        }

                    }
                }
            }
        }
        return numberIsland;
    }

    public static void main(String[] args) {
        char[][] grid= {
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };

        int num = new NumberOfIsland().getNumIsland(grid);
        System.out.println(num);
    }

}
