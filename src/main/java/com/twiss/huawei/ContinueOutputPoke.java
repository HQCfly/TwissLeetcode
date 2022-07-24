package com.twiss.huawei;


import java.util.*;

/**
 * 连续出牌
 * 最大出牌数量
 * @Author: Twiss
 * @Date: 2022/7/23 6:29 下午
 */
public class ContinueOutputPoke {

    public int getMaxPoker(List<List<Integer>> relations, int n){
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> visited = new ArrayDeque<>();// 用于是否访问过
        int res = 1;
        for (int i=0;i<n;i++){
            int tmp =0;
            int[] result = new int[n];
            Arrays.fill(result,1);
            queue.add(i);
            visited.add(i);
            while (!queue.isEmpty()){
                int poll = queue.poll();
                for (int node:relations.get(poll)){
                    if (!visited.contains(node)){
                        visited.add(node);
                        result[node] = result[poll]+1;
                        tmp = Math.max(tmp,result[node]);
                        queue.add(node);
                    }
                }
            }
            res = Math.max(res,tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        String[][] arr =new String[str1.length][2];
        for (int i=0;i<str1.length;i++){
            arr[i][0] = str1[i];
            arr[i][1] = str2[i];
        }
        int n = arr.length;
        // 存储关联关系
        List<List<Integer>> relation = new ArrayList<>(n);
        // 初始化
        for (int i=0;i<n;i++){
            relation.add(new ArrayList<>());
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i!=j){
                    if (arr[i][0].equals(arr[j][0])||arr[i][1].equals(arr[j][1])){
                        relation.get(i).add(j);
                    }
                }
            }
        }
        int ans = new ContinueOutputPoke().getMaxPoker(relation,n);
        System.out.println(ans);
    }
}
