package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/16 8:18 下午
 */
public class PowerOfFour {

    public boolean isPowerOfFour(int n){
        return n>0&&(n&(n-1))==0&&(n&0xaaaaaaaa)==0;
    }

    public boolean isPowerOfFour2(int n){
        return n>0&&(n&(n-1))==0&&n%3==1;
    }

    public static void main(String[] args) {
        int n = 4;
        boolean res = new PowerOfFour().isPowerOfFour(n);
        System.out.println(res);
        boolean res2 = new PowerOfFour().isPowerOfFour2(n);
        System.out.println(res2);
    }
}
