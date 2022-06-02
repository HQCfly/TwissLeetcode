package com.twiss.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * @Author: Twiss
 * @Date: 2022/6/2 3:26 下午
 */
public class IsHappyNumber {

    public boolean isvalid(int n){
        Set<Integer> record = new HashSet<>();
        while (n!=1&&!record.contains(n)){
            record.add(n);
            n = getNextNumber(n);
        }
        return n==1;
    }

    public int getNextNumber(int n){
        int res = 0;
        while (n>0){
            int tmp = n%10;
            res+=tmp*tmp;
            n = n/10;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 19;
        boolean ans = new IsHappyNumber().isvalid(n);
        System.out.println(ans);
    }
}
