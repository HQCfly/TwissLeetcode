package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/2/28 12:00 上午
 */
public class InsertInterval {

    public static int[][] solved(int[][] intervals, int[] newIntervals){
        List<int[]> res = new ArrayList<int[]>();
        int left = newIntervals[0];
        int right = newIntervals[1];
        boolean isPlace = false;

        for (int[] interval: intervals) {
            // newInterval is belong to left side
            if (interval[0] > right){
                if (!isPlace){
                    res.add(new int[]{left, right});
                    isPlace = true;
                }
                res.add(interval);
            } else if (interval[1] < left) {
                res.add(interval);
            } else {
              left = Math.min(interval[0],left);
              right = Math.max(interval[1],right);
            }
        }

        if (!isPlace){
            res.add(new int[]{left,right});
        }

        int[][] newRes = new int[res.size()][2];
        for (int i = 0; i<res.size();++i){
            newRes[i] = res.get(i);
        }
        return newRes;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        int[][] res = solved(intervals,newIntervals);
        for (int[] interval: res){
            System.out.println("["+interval[0]+","+interval[1]+"]");
        }
    }
}
