package com.twiss.heaps;

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
     * @param intervals
     * @return
     */
    public int minMeetingRoom(Interval[] intervals){
        if (intervals==null||intervals.length==0){
            return 0;
        }
        int min = 0;int max = 0;
        //
        for (int i=0;i<intervals.length;i++){
            min = Math.min(min,intervals[i].start);
            max = Math.max(max,intervals[i].end);
        }

        int[] count = new int[max-min+1];
        for (int i=0;i< intervals.length;i++){
            count[intervals[i].start]++;
            count[intervals[i].end]--;
        }

        int maxRoomNums = Integer.MIN_VALUE;
        int num = 0;
        for (int i=0;i< count.length;i++){
            num+=count[i];
            maxRoomNums = Math.max(maxRoomNums,num);
        }
        return maxRoomNums;
    }

    public static void main(String[] args) {

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