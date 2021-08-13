package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/13 1:43 下午
 */
public class BitwiseAndOfNumbersRange {

    public int getRangeBitwiseAnd(int m,int n){
        int shift=0;
        while (m<n){
            m>>=1;
            n>>=1;
            shift++;
        }
        return m<<shift;
    }

    public int getRangeBitwiseAndByBrianKernighan(int m,int n){
        while (m<n){
            n = n&(n-1);
        }
        return n;
    }

    public static void main(String[] args) {
        int m = 9, n=12;
        int res = new BitwiseAndOfNumbersRange().getRangeBitwiseAnd(m,n);
        System.out.println(res);
        int res2 = new BitwiseAndOfNumbersRange().getRangeBitwiseAndByBrianKernighan(m,n);
        System.out.println(res2);
    }

}
