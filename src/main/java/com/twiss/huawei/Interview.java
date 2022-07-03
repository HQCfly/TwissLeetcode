package com.twiss.huawei;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 面试所需要最少面试官
 *
 * @Author: Twiss
 * @Date: 2022/7/2 10:01 下午
 */
public class Interview {

    private static int m, maxTimes;
    private static boolean[] mark;
    private int people;

    public int getMinInterviewer(int[][] interviewTime) {
        if (interviewTime == null || interviewTime.length == 0) {
            return 0;
        }
        m = interviewTime.length;
        people = 0;
        Arrays.sort(interviewTime, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> merged = new ArrayList<int[]>();
        int times = 1;
        merged.add(new int[]{interviewTime[0][0], interviewTime[0][1]});
        for (int i = 1; i < interviewTime.length; ++i) {
            int L = interviewTime[i][0], R = interviewTime[i][1];
            if ((merged.get(merged.size() - 1)[1] <= L)
                    && times < maxTimes) {
                times++;
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            } else {
                times = 1;
                merged.add(new int[]{L, R});
            }
        }
        people = merged.size();
        return people;
    }

    public static void main(String[] args) {

//        int[][] interview = {
//                {1,2},
//                {2,3},
//                {3,4},
//                {4,5},
//                {5,6}
//        };
//        int[][] interview = {
//                {1,2},
//                {2,3},
//                {3,4}
//        };

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            maxTimes = sc.nextInt();
            m = sc.nextInt();
            mark = new boolean[m];
            int[][] interview = new int[m][2];
            sc.nextLine();
            for (int i=0;i<m;i++){
                String[] arr = sc.nextLine().split(" ");
                interview[i][0] = Integer.parseInt(arr[0]);
                interview[i][1] = Integer.parseInt(arr[1]);
            }
            int ans = new Interview().getMinInterviewer(interview);
            System.out.println(ans);
        }
    }
}
