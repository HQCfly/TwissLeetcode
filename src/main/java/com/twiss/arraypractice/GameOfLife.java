package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public static void main(String[] args) {
        int[][] array = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        List<List<Integer>> res = solution(array);
        System.out.println(res);
    }

    public static List<List<Integer>> solution(int[][] array){
        List<List<Integer>> res = new ArrayList<List<Integer>>(){};

        int[] neighbor = {0,1,-1};
        int rows = array.length;
        int cols = array[0].length;

        // 遍历每个格子
        for (int row = 0; row < rows; ++row){
            for (int col = 0; col < cols; ++col){

                // 统计生存的细胞数
                int liveNeighbors = 0;

                for (int i = 0; i < 3; ++i){
                    for (int j = 0; j < 3; ++j){
                        // 快速统计相邻的细胞状态
                        if (!(neighbor[i]==0&&neighbor[j]==0)){
                            int r = (row + neighbor[i]);
                            int c = (col + neighbor[j]);
                            if ((r>=0&&r<rows)&&(c>=0&&c<cols)&&Math.abs(array[r][c])==1){
                                liveNeighbors+=1;
                            }
                        }
                    }
                }

                // 细胞本来活着，因为邻居细胞状态而细胞死亡情况
                if (array[row][col] == 1 && ( liveNeighbors < 2 || liveNeighbors > 3)){
                    // 细胞死亡
                    array[row][col] = -1;
                }

                // 细胞本来死着，因为邻居细胞状态而细胞复活情况
                if (array[row][col] == 0 && liveNeighbors == 3){
                    // 细胞死亡
                    array[row][col] = 2;
                }

            }
        }
        for (int row  = 0; row < rows; ++row){
            List<Integer> cloList = new ArrayList<Integer>();
            for (int clo = 0; clo < cols; ++clo){
                if (array[row][clo]>0){
                    array[row][clo] = 1;
                }else {
                    array[row][clo] = 0;
                }
                cloList.add(array[row][clo]);
            }
            res.add(cloList);
        }

        return res;
    }
}
