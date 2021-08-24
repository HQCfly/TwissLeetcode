package com.twiss.bfs;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/8/24 8:39 下午
 */
public class MinimumHeightTrees {

    public List<Integer> getMinHeightTrees(int n, int[][] edges){
        List<Integer> res = new ArrayList<>();
        if (n==1){
            res.add(0);
            return res;
        }

        // 构建初始化节点出度表
        int[] degree = new int[n];

        // 构建初始化节点关联关系表
        List<List<Integer>> map = new ArrayList<>();
        for (int i=0;i<n;++i){
            map.add(new ArrayList<>());
        }

        for (int[] edge:edges){
            // 对edge两条边进行，出度表更新
            degree[edge[0]]++;
            degree[edge[1]]++;
            // 添加相邻节点
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i=0;i<n;++i){
            if (degree[i]==1){
                deque.offer(i);
            }
        }
        while (!deque.isEmpty()){
            // 这个地方注意，我们每层循环都要new一个新的结果集合，
            // 这样最后保存的就是最终的最小高度树了
            res = new ArrayList<>();
            int currentSize = deque.size();
            for (int i=0;i<currentSize;++i){
                int cur = deque.poll();
                res.add(cur);
                List<Integer> neighbours = map.get(cur);
                for (int nei:neighbours){
                    degree[nei]--;
                    if (degree[nei]==1){
                        deque.offer(nei);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {3,0},
                {3,1},
                {3,2},
                {3,4},
                {5,4}
        };

        int n = 6;

        List<Integer> res = new MinimumHeightTrees().getMinHeightTrees(n,edges);
        System.out.println(JSONObject.toJSONString(res));
    }
}
