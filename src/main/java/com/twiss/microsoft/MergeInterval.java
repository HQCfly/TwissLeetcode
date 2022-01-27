package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/1/27 2:33 下午
 */
public class MergeInterval {

    public int[][] getMergeInterval(int[][] intervals){
        List<int[]> res = new ArrayList<int[]>();
        if (intervals==null||intervals.length==0){
            return res.toArray(new int[0][]);
        }

        // 按照start进行顺序排序
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        for (int i=0;i<intervals.length;++i){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length-1&&right>=intervals[i+1][0]){
                i++;
                right = Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[0][]);
    }

    public List<Interval> getMergeIntervalsByStack(List<Interval> intervals){
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals,Comparator.comparingInt(a->a.start));
        Deque<Interval> stack = new LinkedList<>();
        for (Interval interval:intervals){
            if (stack.isEmpty()||interval.start>stack.peek().end){
                stack.push(interval);
            }else {
                stack.peek().end = Math.max(stack.peek().end,interval.end);
            }
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };

        int[][] res = new MergeInterval().getMergeInterval(intervals);
        System.out.println(JSONObject.toJSONString(res));

        Interval interval = new Interval(1,3);
        Interval interval2 = new Interval(2,6);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,18);
        List<Interval> tmp = new ArrayList<>();
        tmp.add(interval);
        tmp.add(interval2);
        tmp.add(interval3);
        tmp.add(interval4);
        List<Interval> res2 = new MergeInterval().getMergeIntervalsByStack(tmp);
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

