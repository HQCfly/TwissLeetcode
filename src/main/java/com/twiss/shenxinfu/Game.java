package com.twiss.shenxinfu;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/3/9 8:43 下午
 */
public class Game {

    int res = 0;
    public int coinGame (int[] arr) {
        HashMap<Integer,Integer> count = new HashMap<>();
        for (int nums:arr){
            count.put(nums,count.getOrDefault(nums,0)+1);
        }
        Queue<Integer> deque = new PriorityQueue<>((a,b)->b-a);
        deque.addAll(count.keySet());
        if (deque.isEmpty()){
            return 0;
        }
        res = deque.peek();
        dfs(deque,count,0);
        return res;
    }

    private void dfs(Queue<Integer> deque, HashMap<Integer,Integer> counts,int split){
        if (deque.isEmpty()){
            return;
        }
        int max = deque.poll();
        int count = counts.get(max);
        if (count<max/2){
            if (!counts.containsKey(max/2)){
                deque.add(max/2);
            }
            if (!counts.containsKey(max-max/2)){
                deque.add(max-max/2);
            }
            counts.put(max/2,counts.getOrDefault(max/2,0)+count);
            counts.put(max-max/2,counts.getOrDefault(max-max/2,0)+count);
            dfs(deque,counts,split);
        }
        res = Math.min(split+max,res);
    }
}
