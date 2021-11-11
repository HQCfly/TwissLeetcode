package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/11/10 11:14 下午
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals){
        List<int[]> ans = new ArrayList<>(10);
        Arrays.sort(intervals, ((o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i=1;i<intervals.length;++i){
            if (intervals[i][0]<=end){
                end = Math.max(end,intervals[i][1]);
            }else {
                ans.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start,end});
        int[][] res = new int[ans.size()][2];
        for (int i =0;i<res.length;i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{4,5}};
        int[][] res = new MergeIntervals().merge(intervals);
        System.out.println(JSONObject.toJSONString(res));
    }
}
