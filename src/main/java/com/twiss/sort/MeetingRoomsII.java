package com.twiss.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Twiss
 * @Date: 2021/11/4 11:04 下午
 */
public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals){
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a.start-b.start);
        // 按照end维护一个最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i =0;i<n;i++){
            // 比较start时间是否大于最小堆中的end时间，如果大于则将堆顶推出
            if (i>0&&pq.size()>0&&intervals[i].start>=pq.peek()){
                pq.poll();
            }
            pq.add(intervals[i].end);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(0,30);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,20);
        Interval[] intervals = {interval1,interval2,interval3};
        int res = new MeetingRoomsII().minMeetingRooms(intervals);
        System.out.println(res);
    }
}
class Interval {
    int start;
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