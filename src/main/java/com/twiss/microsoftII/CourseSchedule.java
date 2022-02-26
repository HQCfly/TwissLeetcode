package com.twiss.microsoftII;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/2/26 7:57 下午
 */
public class CourseSchedule {

    public boolean canFinished(int courseNumber, int[][] course) {

        // 1. 创建入度表，入度为0的表示没有依赖course[0]
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < courseNumber; ++i) {
            inDegree.put(i, 0);
        }
        // 2. 创建被依赖课程的链表course[1]
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        // 3. 初始化入度表和依赖关系
        initInDegreeAndDepend(inDegree, adj, course);
        // 4. 将入度为0的课程放入队列，队列中的课程就没有先修课，可以学的课程
        // 遍历当期那邻接表，更新其入度；更新后查看入度是否0，加入队列中
        Deque<Integer> deque = new ArrayDeque<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                deque.offer(key);
            }
        }
        // 5. 取出节点对应学习这门课
        // 遍历当期那邻接表，更新其入度；更新后查看入度是否0，加入队列中
        bfs(inDegree,adj,deque);
        // 6. 遍历入队，如果有课程的入度不为0，返回false
        for (int key:inDegree.keySet()){
            if (inDegree.get(key)!=0){
                return false;
            }
        }
        return true;
    }

    private void initInDegreeAndDepend(Map<Integer, Integer> inDegree,
                                       Map<Integer, List<Integer>> adj,
                                       int[][] prerequisites) {
        for (int[] course : prerequisites) {
            int curr = course[1];
            int next = course[0];
            inDegree.put(next, inDegree.get(next) + 1);
            if (!adj.containsKey(curr)) {
                adj.put(curr, new ArrayList<>());
            }
            adj.get(curr).add(next);
        }
    }

    private void bfs(Map<Integer, Integer> inDegree,
                     Map<Integer, List<Integer>> adj,
                     Deque<Integer> deque) {
        while (!deque.isEmpty()){
            // 去除队列队首元素
            int curr = deque.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(curr)){
                continue;
            }
            // adj key是被依赖的课程，value是后置课程
            List<Integer> next = adj.get(curr);
            for (Integer course:next){
                inDegree.put(course,inDegree.get(course)-1);
                if (inDegree.get(course)==0){
                    deque.offer(course);
                }
            }
        }
    }

    /**
     *          0
     *              \
     *                  3
     *              /       \
     *          1               5
     *              \       /
     *                  4
     *              /
     *          2
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
