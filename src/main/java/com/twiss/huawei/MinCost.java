package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 最小价值
 * @Author: Twiss
 * @Date: 2022/7/26 11:00 下午
 */
public class MinCost {

    public int process(int x , int n , int[] nums){
        if (x<n){
            return 0;
        }
        if (x==n){
            return n*2;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        System.out.println("heap:"+ JSONObject.toJSONString(heap));
        while (heap.size()!=n){
            int num = 0;
            while (heap.size()>=0&&num<heap.peek()){
                if (heap.size()==n-1){
                    break;
                }
                num+=heap.poll();
            }
            heap.add(num);
        }
        System.out.println("heap:"+ JSONObject.toJSONString(heap));
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!heap.isEmpty()){
            Integer poll = heap.poll();
            map.put(poll,map.getOrDefault(poll,0)+1);
        }
        System.out.println("map:"+ JSONObject.toJSONString(map));
        int ans = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)==1){
                ans++;
            }
        }
        return n*2+ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i=0;i<arr.length;i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int ans = new MinCost().process(x,n,nums);
        System.out.println(ans);
    }
}
