package com.twiss.huawei;

import java.util.Scanner;

/**
 * 分糖果II
 * 使用异或算法，先整体异或如果0则可分，将最小的分给弟弟
 * @Author: Twiss
 * @Date: 2022/7/13 3:35 下午
 */
public class DivideCandyII {

    public String getMaxCandy(int[]arr){
        if (arr==null||arr.length==0||arr.length==1||
                (arr.length==2&&arr[0]!=arr[1])){
            return "NO";
        }
        int min = arr[0];
        int sum = min;
        int tmp = min;
        for (int i=1;i<arr.length;i++){
            sum+=arr[i];
            min = Math.min(min, arr[i]);
            tmp^=arr[i];
        }
        if (tmp!=0){
            return "NO";
        }else {
            return String.valueOf(sum-min);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            String ans = new DivideCandyII().getMaxCandy(arr);
            System.out.println(ans);
        }
    }

}
