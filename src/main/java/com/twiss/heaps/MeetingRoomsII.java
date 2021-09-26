package com.twiss.heaps;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: Twiss
 * @Date: 2021/9/24 10:02 下午
 */
public class MeetingRoomsII {

    /**
     * 把区间变成2个数组：start时间数组和end时间数组，
     * 并对两个数组排序。然后一个指针遍历start数组，
     * 另一个指针指向end数组。如果start时间小于end时间，
     * 房间数就加1，start时间加1，比较并记录出现过的最多房间数。
     * start时间大于end，则所需房间数就减1，end指针加1。
     *
     * @param intervals
     * @return
     */
    public int minMeetingRoom(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int min = 0;
        int max = 0;
        // 在start时间中寻找最小的开始时间
        // 在end时间中寻找最大的结束时间
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i].start);
            max = Math.max(max, intervals[i].end);
        }
        // 设置一个数组
        int[] count = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            count[intervals[i].start]++;
            count[intervals[i].end]--;
        }
        int maxRoomNums = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < count.length; i++) {
            num += count[i];
            maxRoomNums = Math.max(maxRoomNums, num);
        }
        return maxRoomNums;
    }

    public int minMeetingRoomByMinHeap(Interval[] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && intervals[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(intervals[i].end);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Interval interval = new Interval(0, 30);
        Interval interval2 = new Interval(5, 10);
        Interval interval3 = new Interval(15, 20);

        Interval[] intervals = {interval, interval2, interval3};

        int res = new MeetingRoomsII().minMeetingRoom(intervals);
        System.out.println(res);

        Interval[] intervals2 = {interval, interval2, interval3};
        int res2 = new MeetingRoomsII().minMeetingRoomByMinHeap(intervals2);
        System.out.println(res2);

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