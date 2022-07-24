package com.twiss.huawei;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 打印任务排队
 * 构建一个队列+最大堆
 * @Author: Twiss
 * @Date: 2022/7/23 9:48 下午
 */
public class PrintTaskSorted {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        int n = s.length;
        int[] nums = new int[s.length];
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        Deque<Integer> queue= new ArrayDeque<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
        for (int i=0;i<n;i++){
            queue.offer(nums[i]);
            priorityQueue.offer(new int[]{nums[i],i});
        }
        int index = 0;
        int[] res = new int[n];
        while (!queue.isEmpty()){
            int poll1 = queue.poll();
            int[] poll2 = priorityQueue.poll();
            if (poll1 == poll2[0]) {
                // 按打印顺序存储结果
                res[poll2[1]] = index;
                index++;

            } else {
                queue.offer(poll1);
                priorityQueue.offer(poll2);
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            if (i != res.length - 1) {
                System.out.print(",");
            }
        }
    }
}
