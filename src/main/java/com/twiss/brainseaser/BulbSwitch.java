package com.twiss.brainseaser;

/**
 * @Author: Twiss
 * @Date: 2021/8/18 5:05 下午
 */
public class BulbSwitch {

    public int getBulbSwitch(int n){
        return (int)Math.floor(Math.sqrt(n));
    }

    public static void main(String[] args) {
        int n = 3;
        int ans = new BulbSwitch().getBulbSwitch(n);
        System.out.println(ans);
    }
}
