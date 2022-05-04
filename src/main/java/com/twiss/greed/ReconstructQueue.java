package com.twiss.greed;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 根据身高重建队列
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/5/4 10:20 下午
 */
public class ReconstructQueue {

    public int[][] getQueue(int[][] people){
        if (people==null||people.length==0){
            return null;
        }
        Arrays.sort(people,(a,b)->{
            if (a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        LinkedList<int[]> queue = new LinkedList<int[]>();
        for (int[] p:people){
            queue.add(p[1],p);
        }
        return queue.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] people = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        int[][] ans = new ReconstructQueue().getQueue(people);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
