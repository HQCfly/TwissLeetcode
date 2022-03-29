package com.twiss.baidu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/3/29 8:06 下午
 */
public class TheNumberOfN {

    public static boolean getNum(int a,int b){
        if (b%a==0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTest = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int m=0;m<numberOfTest;++m){
            int tmp = scanner.nextInt();
            list.add(tmp);
        }
        for (int i=0;i<list.size();++i){
            int n = list.get(i);
            int num =0, sum =0;
            int[] arr = new int[n];
            for (int j=1;j*j<n;++j){
                if (n%j==0){
                    arr[num++]=j;
                    if (j*j!=n){
                        arr[num++] = n/j;
                    }
                }
            }
            List<Integer> tmp = new ArrayList<>();
            for (int q=0;q<arr.length;++q){
                if (arr[q]!=0){
                    tmp.add(arr[q]);
                }
            }
            for (int k=0;k<num;k=k+2){
                int l = k+1;
                if (getNum(tmp.get(k),tmp.get(l))){
                    sum++;
                }
            }
            int ans = sum+1;
            System.out.println(ans);
        }
    }
}
