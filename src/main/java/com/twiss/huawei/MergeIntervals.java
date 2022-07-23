package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 合并区间
 * @Author: Twiss
 * @Date: 2022/7/23 11:56 上午
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals){
        List<int[]> ans = new ArrayList<>();
        if (intervals==null||intervals.length==0){
            return null;
        }
        Arrays.sort(intervals,((o1, o2) -> o1[0]-o2[0]));
        int start = intervals[0][0];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0]>intervals[i-1][1]){
                ans.add(new int[]{start,intervals[i-1][1]});
                start = intervals[i][0];
            }else {
                intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);
            }
        }
        ans.add(new int[]{start,intervals[intervals.length-1][1]});
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int[][] arr = new int[strArr.length/2][2];
        int index = 0;
        for (int i=0;i<strArr.length;i+=2){
            arr[index][0] = Integer.parseInt(strArr[i]);
            arr[index][1] = Integer.parseInt(strArr[i+1]);
            index++;
        }
        int[][] ans = new MergeIntervals().merge(arr);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
