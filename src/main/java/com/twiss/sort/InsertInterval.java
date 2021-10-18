package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/10/18 10:18 下午
 */
public class InsertInterval {

    /**
     * 1. 在插入区间的右侧且无交集，直接加入newIntervals到结果中，
     * 然后再加入该位置的intervals
     * 2. 在插入区间的左侧且无交集，直接加入该位置的intervals，然后遍历下一个
     * 3. 与插入区间有交集，计算它们的并集： left = Math.min(left,intervals[0])
     * right = Math.max(right,intervals[1])
     * @param intervals
     * @param newIntervals
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newIntervals){
        int left = newIntervals[0];
        int right = newIntervals[1];
        // 判断newInterval是否已经加入结果中
        boolean placed = false;
        List<int[]> ansList = new ArrayList<>();
        for (int[] interval: intervals){
            // 在插入区间的右侧且无交集
            if (right<interval[0]){
                if (!placed){
                    ansList.add(new int[]{left,right});
                    placed = true;
                }
                ansList.add(interval);
            }else if (left>interval[1]){
                // 在插入区间的左侧且无交集
                ansList.add(interval);
            }else {
                // 与插入区间有交集
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if (!placed){
            ansList.add(new int[]{left,right});
        }
        int[][] ans = new int[ansList.size()][2];
        for (int i=0;i<ansList.size();++i){
            ans[i] = ansList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] res = new InsertInterval().insert(intervals,newInterval);
        System.out.println(JSONObject.toJSONString(res));
    }
}
