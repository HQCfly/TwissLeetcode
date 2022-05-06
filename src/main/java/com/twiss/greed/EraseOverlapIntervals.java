package com.twiss.greed;

import java.util.Arrays;

/**
 * 移除区间
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/6 1:01 下午
 */
public class EraseOverlapIntervals {

    public int getRemoveCount(int[][] intervals){
        if (intervals==null||intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int pre = intervals[0][1];
        int count = 0;
        for (int i=1;i<intervals.length;i++){
            if (pre>intervals[i][0]){
                count++;
                pre = Math.min(pre,intervals[i][1]);
            }else {
                pre = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        int ans = new EraseOverlapIntervals().getRemoveCount(intervals);
        System.out.println(ans);
    }
}
