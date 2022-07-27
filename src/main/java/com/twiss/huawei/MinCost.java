package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 最小价值
 *
 * @Author: Twiss
 * @Date: 2022/7/26 11:00 下午
 */
public class MinCost {

    public int process(int x, int n, int[] nums) {
        if (x < n) {
            return 0;
        }
        if (x == n) {
            return n * 2;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        System.out.println("heap:" + JSONObject.toJSONString(heap));
        while (heap.size() != n) {
            int num = 0;
            while (heap.size() >= 0 && num < heap.peek()) {
                if (heap.size() == n - 1) {
                    break;
                }
                num += heap.poll();
            }
            heap.add(num);
        }
        System.out.println("heap:" + JSONObject.toJSONString(heap));
        HashMap<Integer, Integer> map = new HashMap<>();
        while (!heap.isEmpty()) {
            Integer poll = heap.poll();
            map.put(poll, map.getOrDefault(poll, 0) + 1);
        }
        System.out.println("map:" + JSONObject.toJSONString(map));
        int ans = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                ans++;
            }
        }
        return n * 2 + ans;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        int n = sc.nextInt();
//        sc.nextLine();
//        String[] arr = sc.nextLine().split(" ");
//        int[] nums = new int[arr.length];
//        for (int i=0;i<arr.length;i++){
//            nums[i] = Integer.parseInt(arr[i]);
//        }

        int x = 5;
        int n = 3;
        int[] shu = new int[]{1, 2, 3, 4, 5};
        //int[] res=new int[n];
        List<Integer>[] res = new List[n];
        for (int m = 0; m < n; m++) {
            res[m] = new ArrayList<Integer>();
        }
        int pass = x % n;
        Arrays.sort(shu);
        int i = 0;
        int j = 0;
        while (i < x) {
            res[j].add(shu[i]);
            if (i == 0 && pass > 0) i = i + 1 + pass;
            else i++;
            j = (j + 1) % n;
        }
        int newi = 1;
        int newj = 0;
        while (pass > 0 && newi < x) {
            res[newj].add(shu[newi]);
            i++;
            pass--;
        }
        int len = res.length;
        System.out.println(JSONObject.toJSONString(res));
    }
}
