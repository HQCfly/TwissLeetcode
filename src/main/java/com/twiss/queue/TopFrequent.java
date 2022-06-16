package com.twiss.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 前k个高频元素
 * @Author: Twiss
 * @Date: 2022/6/15 9:53 下午
 */
public class TopFrequent {

    public int[] getFrequent(int[] nums,int k){
        if (nums==null||nums.length==0){
            return null;
        }
        int[] res = new int[k];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        Set<Map.Entry<Integer,Integer>> entries = hashMap.entrySet();
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        // 遍历全部的元素，维持元素为k的最小堆。先构建一个k+1的最小堆，可以确定当前堆中最小值，然后将堆顶元素移除即可。
        for (Map.Entry<Integer,Integer> entry:entries){
            System.out.println(JSONObject.toJSONString(entry));
            queue.offer(entry);
            if (queue.size()>k){
                queue.poll();
            }
        }
        for (int i=k-1;i>=0;i--){
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4};
        int k = 2;
        int[] ans = new TopFrequent().getFrequent(nums,k);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
