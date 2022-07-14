package com.twiss.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 高效的任务规划
 *
 * @Author: Twiss
 * @Date: 2022/7/14 6:27 下午
 */
public class AssignmentArrangement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int N = sc.nextInt();
            // 动态规划
            int res = 0, last = 0, dp = 0;
            int[][] machine = new int[N][2];
            for (int j = 0; j < N; j++) {
                machine[j][0] = sc.nextInt();
                machine[j][1] = sc.nextInt();
            }
            // 根据machine的执行时间进行倒排
            Arrays.sort(machine, (o1, o2) -> o2[1] - o1[1]);
            for (int k = 0; k < N; k++) {
                dp = last + machine[k][0] + machine[k][1];
                last += machine[k][1];
                res = Math.max(res, dp);
            }
            System.out.println(res);
        }
    }
}
