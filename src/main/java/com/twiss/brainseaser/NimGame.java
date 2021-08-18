package com.twiss.brainseaser;

/**
 * @Author: Twiss
 * @Date: 2021/8/18 4:28 下午
 */
public class NimGame {

    public boolean canWin(int n){
    return (n%4!=0);
    }

    public static void main(String[] args) {
        int n = 5;
        boolean res = new  NimGame().canWin(n);
        System.out.println(res);
    }
}
