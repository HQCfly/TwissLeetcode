package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 面试所需要最少面试官
 * @Author: Twiss
 * @Date: 2022/7/2 10:01 下午
 */
public class Interview {

    private int m,maxTimes;
    private boolean[] mark;
    private int people;

    public int getMinInterviewer(int[][] interviewTime){
        if (interviewTime==null||interviewTime.length==0){
            return 0;
        }
        m = interviewTime.length;
        mark = new boolean[m];
        people = 0;
        maxTimes = 3;
        Arrays.sort(interviewTime,(o1,o2)->o1[0]-o2[0]);
        List<int[]> merged = new ArrayList<int[]>();
        int times = 1;
        merged.add(new int[]{interviewTime[0][0],interviewTime[0][1]});
        for (int i = 1; i < interviewTime.length; ++i) {
            int L = interviewTime[i][0], R = interviewTime[i][1];
            if ((merged.get(merged.size() - 1)[1] <= L)
                    &&times<maxTimes) {
                times++;
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            } else {
                times=1;
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

        int[][] interview = {
                {8,35},
                {5,10},
                {1,3}
        };
        int ans = new Interview().getMinInterviewer(interview);
        System.out.println(ans);
    }
}
