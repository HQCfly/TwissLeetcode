package com.twiss.microsoft;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/1/18 8:11 下午
 */
public class CourseSchedule {

    public boolean canFinished(int courseNums, int[][] prerequisites) {
        // 1.课号对应的入度
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < courseNums; ++i) {
            inDegree.put(i, 0);
        }
        // 2. 依赖关系，{0,[3]} 0表示当前课程，表示依赖当前的后续课程
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // 3. 初始化入度表和依赖关系
        initInDegreeAndDepend(inDegree, adj, prerequisites);

        // 4. 选择入度为0的课程入队列，这样队列中都是没有先修课的课程
        Deque<Integer> deque = new ArrayDeque<>();
        for (int course:inDegree.keySet()){
            if (inDegree.get(course)==0){
                deque.offer(course);
            }
        }
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
            // 更新入度表
            inDegree.put(next, inDegree.get(next) + 1);
            // 更新邻接表
            if (!adj.containsKey(curr)) {
                adj.put(curr, new ArrayList<>());
            }
            adj.get(curr).add(next);
        }
    }

    private void bfs(Map<Integer, Integer> inDegree,
                     Map<Integer, List<Integer>> adj,
                     Deque<Integer> deque){
        while (!deque.isEmpty()){
            int curr = deque.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(curr)){
                continue;
            }
            List<Integer> next = adj.get(curr);
            for (int course: next){
                inDegree.put(course,inDegree.get(course)-1);
                if (inDegree.get(course)==0){
                    deque.offer(course);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] course = {
                {3,0},
                {3,1},
                {4,1},
                {4,2},
                {5,3},
                {5,4}
        };
        int numberCourse = 6;

        boolean res = new CourseSchedule().canFinished(numberCourse,course);
        System.out.println(res);
    }
}
