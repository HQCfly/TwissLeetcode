package com.twiss.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Twiss
 * @Date: 2021/8/25 8:10 下午
 */
public class NumberOfConnected {

    public int countComponents(int n, int[][] edges) {
        int count = 0;
        List<List<Integer>> g = new ArrayList<>();
        boolean[] visited = new boolean[n];
        // 创建初始化邻接表
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        // 对改节点添加邻居节点
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        // 遍历
        for (int i = 0; i < n; i++) {

            // 节点是否已经遍历过
            if (!visited[i]) {
                count++;
                // 使用bfs去检查是所有的关联节点，并将visited置为true
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    visited[index] = true;
                    for (int next : g.get(index)) {
                        if (!visited[next]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] edge2 = {{0,1},{1,2},{3,4}};
        int n = 5;
        int res = new NumberOfConnected().countComponents(n,edge2);
        System.out.println(res);
    }
}
