package com.twiss.greed;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/6 4:31 下午
 */
public class Merge {

    public int[][] getMerger(int[][] intervals){

        if (intervals==null||intervals.length==0){
            return null;
        }
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]));
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0]>intervals[i-1][1]){
                ans.add(new int[]{start,intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1]= Math.max(intervals[i][1],intervals[i-1][1]);
            }
        }
        ans.add(new int[]{start,intervals[intervals.length-1][1]});
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] ans = new Merge().getMerger(intervals);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
