package com.twiss.threesixzero;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/8/27 4:05 下午
 */
public class ToQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] con = sc.nextLine().split(" ");
        int m = Integer.parseInt(con[0]);
        int n = Integer.parseInt(con[1]);
        int[][] arrs = new int[m][n];
        for (int i=0;i<m;i++){
            String[] tmp = sc.nextLine().split(" ");
            for (int j=0;j<n;j++){
                arrs[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int sum = Integer.MIN_VALUE;
        for (int j=0;j<n;j++){
            int tmpSum = 0;
            for (int i=0;i<m;i++){

                tmpSum+=arrs[i][j];
            }
            sum = Math.max(sum,tmpSum);
        }
        int ans = sum+1;
        System.out.println(ans);
    }
}
