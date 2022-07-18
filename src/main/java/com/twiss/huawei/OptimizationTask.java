package com.twiss.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 最优任务调度器
 * @Author: Twiss
 * @Date: 2022/7/18 11:03 下午
 */
public class OptimizationTask {

    public int getMinTime(int[] tasks, int n){
        Map<Integer,Integer> freq = new HashMap<>();
        // 最大执行次数
        int maxExec = 0;
        for (int t:tasks){
            int exec = freq.getOrDefault(t,0)+1;
            freq.put(t,exec);
            maxExec = Math.max(maxExec,exec);
        }
        // 寻找有多少个具备最大执行次数的任务
        int maxCount = 0;
        Set<Map.Entry<Integer,Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Integer,Integer> entry:entrySet){
            int value = entry.getValue();
            if (value==maxExec){
                maxCount++;
            }
        }
        return Math.max((maxExec-1)*(n+1)+maxCount,tasks.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arrs = sc.nextLine().split(",");
        int n = sc.nextInt();
        int len = arrs.length;
        int[] tasks = new int[len];
        for (int i=0;i<len;i++){
            tasks[i] = Integer.parseInt(arrs[i]);
        }
        int ans = new OptimizationTask().getMinTime(tasks,n);
        System.out.println(ans);
    }
}
