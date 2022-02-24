package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 时间复杂度O(nlogN)
 * 空间复杂度O(nlogN)
 * @Author: Twiss
 * @Date: 2022/2/24 11:52 上午
 */
public class MergeSpace {

    public int[][] getMerge(int[][] intervals){

        if (intervals.length==0){
            return new int[0][2];
        }
        // 先排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i=0;i<intervals.length;++i){
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (ans.size()==0||ans.get(ans.size()-1)[1]<left){
                ans.add(new int[]{left,right});
            }else {
                ans.get(ans.size()-1)[1] = Math.max(right,ans.get(ans.size()-1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
        int[][] ans = new MergeSpace().getMerge(intervals);
        System.out.println(JSONObject.toJSONString(ans));
    }

}
