package com.twiss.bfs;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/8/22 4:16 下午
 */
public class CourseScheduleII {

    private static List<Integer> res = new ArrayList<>();

    public List<Integer> getOrderCourses(int numCourse, int[][] prerequisites){
        // 1. 课号和对应的入度
        Map<Integer,Integer> inDegree = new HashMap<>();
        for (int i=0;i<numCourse;++i){
            inDegree.put(i,0);
        }
        // 2. 依赖关系，{0,[3]} 0表示当前课程，表示依赖当前的后续课程
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // 3. 初始化入度表和依赖关系
        initInDegreeAndDepend(inDegree,adj,prerequisites);
        // 4. 将入度为0的课程放入队列，队列中的课程就没有先修课，可以学的课程
        Deque<Integer> deque = new LinkedList<>();
        for (int key:inDegree.keySet()){
            if (inDegree.get(key)==0){
                deque.offer(key);
                res.add(key);
            }
        }
        // 5. 取出节点对应学习这门课
        // 遍历当期那邻接表，更新其入度；更新后查看入度是否0，加入队列中
        bfs(inDegree,adj,deque);
        // 6. 遍历入队，如果有课程的入度不为0，返回false
        for (int key:inDegree.keySet()){
            if (inDegree.get(key)!=0){
                return new ArrayList<>();
            }
        }
        return res;
    }

    private void initInDegreeAndDepend(Map<Integer,Integer> inDegree,
                                       Map<Integer, List<Integer>> adj,
                                       int[][] prerequisites){
        for (int[] course:prerequisites){
            int cur = course[1];
            int next = course[0];
            // 更新next的入度表
            inDegree.put(next,inDegree.get(next)+1);
            // 更新cur的依赖关系
            if (!adj.containsKey(cur)){
                adj.put(cur,new ArrayList<>());
            }
            adj.get(cur).add(next);
        }
    }

    /**
     * 遍历邻接表和入度表。如果遍历到当前课程，寻找出依赖的课程，并且将其减去入度1
     * @param inDegree
     * @param adj
     * @param deque
     */
    private void bfs(Map<Integer,Integer> inDegree,
                     Map<Integer, List<Integer>> adj,
                     Deque<Integer> deque){
        while (!deque.isEmpty()){
            int cur = deque.poll();
            // 遍历当前课程的邻接表, 更新后继节点的入度
            if (!adj.containsKey(cur)){
                continue;
            }
            List<Integer> next = adj.get(cur);
            for (int course: next){
                inDegree.put(course,inDegree.get(course)-1);
                if (inDegree.get(course)==0){
                    deque.offer(course);
                    res.add(course);
                }
            }
        }
    }

    /**
     *
     *
     *
     *                  1
     *              /       \
     *          0               3
     *              \       /
     *                  2
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] courses = {
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        int numberCourse = 4;

        List<Integer> res = new CourseScheduleII().getOrderCourses(numberCourse,courses);
        System.out.println(res);

    }
}
