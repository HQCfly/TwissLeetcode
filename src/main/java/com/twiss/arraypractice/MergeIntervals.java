package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/3/16 9:05 下午
 */
public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();
        if (intervals.length == 0 || intervals == null) {
            return res.toArray(new int[0][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        System.out.println(JSONObject.toJSONString(res));
    }
}
