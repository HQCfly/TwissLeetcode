package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/16 8:18 下午
 */
public class PowerOfTwo {

    private static final int BIG = 1<<30;

    public boolean isPowerOfFour(int n){
        return n>0&&BIG%n==0;
    }

    public boolean isPowerOfFour2(int n){
        return n>0&&(n&(n-1))==0;
    }

    public static void main(String[] args) {
        int n = 9;
        boolean res = new PowerOfTwo().isPowerOfFour(n);
        System.out.println(res);
        boolean res2 = new PowerOfTwo().isPowerOfFour2(n);
        System.out.println(res2);
    }
}
