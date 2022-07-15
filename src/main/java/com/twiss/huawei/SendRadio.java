package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

/**
 * 发广播
 * @Author: Twiss
 * @Date: 2022/7/15 5:14 下午
 */
public class SendRadio {

    public int getSite(int[][] grids){
        if (grids==null||grids.length==0){
            return 0;
        }
        int count = 0;
        int row = grids.length, col = grids[0].length;
        for (int i=0;i<row;i++){
            for (int j=i+1;j<col;j++){
                if (grids[i][j]==0){
                    count++;
                }
            }
        }
        if (count==0){
            return 1;
        }else {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr  = sc.nextLine().split(",");
        int[][] grids = new int[arr.length][arr.length];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                grids[i][j] = Integer.parseInt(String.valueOf(arr[i].charAt(j)));
            }
        }
        int ans = new SendRadio().getSite(grids);
        System.out.println(ans);
    }
}
