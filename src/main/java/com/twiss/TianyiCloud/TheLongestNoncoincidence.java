package com.twiss.TianyiCloud;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 不重合最长区间长度
 * @Author: Twiss
 * @Date: 2022/6/29 11:39 上午
 */
public class TheLongestNoncoincidence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            int[][] intervals = new int[n][2];
            for (int i=0;i<n;i++){
                String[] s = sc.nextLine().split(",");
                intervals[i][0] = Integer.parseInt(s[0]);
                intervals[i][1] = Integer.parseInt(s[1]);
            }
            Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
            int len = 0;
            for (int i=0;i<n-1;i++){
                int left = intervals[i][0], right = intervals[i][1];
                // 表示后一区间重叠当前区间
                if (intervals[i+1][1]<=left){
                    len += Math.abs(intervals[i+1][1]-intervals[i+1][0]);
                }else if (intervals[i+1][0]<right&&intervals[i+1][1]>right){
                    // 后一区间左边界与当前区间重合
                    len += Math.abs(right-intervals[i+1][0]);
                }
            }
            int sumLen = intervals[n-1][1]-intervals[0][0];
            int ans = sumLen-len;
            System.out.println(ans);
        }
    }
}
