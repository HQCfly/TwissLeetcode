package com.twiss.huawei;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/7/27 7:43 下午
 */
public class ThreeOnly {

    private static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        nums = new int[input.length];
        int[][] arr = new int[3][3];
        boolean[][] cols = new boolean[3][3];
        boolean[][] rows = new boolean[3][3];
        boolean[][] blocks = new boolean[3][3];

        for (int i=0;i<arr.length;i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        dfs(arr,cols,rows,blocks);

    }

    private static boolean dfs(int[][] arr, boolean[][] cols,
                            boolean[][] rows, boolean[][] blocks){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (arr[i][j]==0){
                    int k=(i%3)*3+j%3;
                    for (int l=0;l<9;l++){
                        if (!cols[j][l]&&!rows[i][l]&&!blocks[k][l]){
                            rows[i][l] = cols[j][l] = blocks[k][l] =true;
                            arr[i][j] = nums[l];
                            if (dfs(arr,cols,rows,blocks)){
                                return true;
                            }
                            rows[i][l] = cols[j][l] = blocks[k][l] =true;
                            arr[i][j] = 0;
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }
}
