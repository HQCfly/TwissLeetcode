package com.twiss.huawei;

import java.util.*;

/**
 * 最长广播效应
 * @Author: Twiss
 * @Date: 2022/7/24 11:08 下午
 */
public class LongestBroadcast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        // 使用hashMap存储节点的连接关系
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < T; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            if (!map.containsKey(start)) {
                map.put(start, new HashSet<>());
            }
            if (!map.containsKey(end)) {
                map.put(end, new HashSet<>());
            }
            map.get(start).add(end);
            map.get(end).add(start);
        }
        int head = in.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        queue.add(head);
        Set<Integer> visited = new HashSet<>();  // 判断是否已经访问过
        int[] d = new int[N + 1];  // 最短路径长度数组
        while (!queue.isEmpty()) {
            int poll = queue.pollFirst();
            for (int node : map.get(poll)) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    d[node] = d[poll] + 1;
                    queue.add(node);
                }
            }
        }
        int res = 0; // 最大最短路径
        for (int i = 1; i < N + 1; i++) {
            res = Math.max(res, d[i]);
        }
        System.out.println(res * 2);
    }
}
