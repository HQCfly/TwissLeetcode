package com.twiss.heaps;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/9/30 12:14 下午
 */
public class SuperUglyNumber {

    public int nthSuperUglyNum(int n, int[] primes){
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        set.add(1L);
        while (n-->0){
            long x = queue.poll();
            if (n==0) {
                return (int)x;
            }
            for (int k: primes){
                if (!set.contains(k*x)){
                    set.add(k*x);
                    queue.add(k*x);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] primes = {2,7,13,19};
        int n = 12;
        int res = new SuperUglyNumber().nthSuperUglyNum(12,primes);
        System.out.println(res);
    }
}
