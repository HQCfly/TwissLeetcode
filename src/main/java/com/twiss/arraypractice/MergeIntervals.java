package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

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
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static List<Interval> merge2(List<Interval> intervals){
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() { public int compare(Interval a, Interval b) {
            return a.start - b.start; }
        });

        Stack<Interval> stack = new Stack<Interval>();
        for (Interval interval:intervals){
            if (stack.empty()||interval.start>stack.peek().end){
                stack.push(interval);
            }else {
                stack.peek().end = Math.max(interval.end,stack.peek().end);
            }
        }

        while (!stack.empty()){
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        System.out.println(JSONObject.toJSONString(res));

        Interval interval = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);
        List<Interval> timeIntervals = new ArrayList<Interval>();
        timeIntervals.add(interval);
        timeIntervals.add(interval2);
        timeIntervals.add(interval3);
        timeIntervals.add(interval4);
        List<Interval> res2 = merge2(timeIntervals);
        System.out.println(JSONObject.toJSONString(res2));
    }
}

class Interval {
    int start;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}