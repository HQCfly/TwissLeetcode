package com.twiss.heaps;

import java.util.PriorityQueue;

/**
 * @Author: Twiss
 * @Date: 2021/9/16 7:09 下午
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> l = new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a,b)->a-b);

    public static void main(String[] args) {

    }
}
