package com.twiss.guanglianda;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/8/31 10:26 下午
 */
public class IntervalsProblem {
    private List<Integer> peoples;

    public int[][] getMerge(int[][] intervals,int[] people){
        if (intervals.length == 0) {
            return new int[0][2];
        }
        peoples = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                System.out.println(i);
                peoples.add(people[i- 1]+people[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] config = sc.nextLine().split(" ");
        int n = Integer.parseInt(config[0]);
        int m = Integer.parseInt(config[1]);
        int[][] arr = new int[m][2];
        int[] people = new int[m];

        for (int i=0;i<m;i++){
            String[] tmp = sc.nextLine().split(" ");
            arr[i][0] = Integer.parseInt(tmp[0]);
            arr[i][1] = Integer.parseInt(tmp[1]);
            people[i] = Integer.parseInt(tmp[2]);
        }
        IntervalsProblem inp = new IntervalsProblem();
        int[][] merge = inp.getMerge(arr,people);
        System.out.println(JSONObject.toJSONString(merge));
        System.out.println(JSONObject.toJSONString(inp.peoples));
        int ans = 0;
        int tmpRight = 0;
        for (int i=0;i<merge.length;i++){

            int left = merge[i][0];
            int right = merge[i][1];

            if (right-left+1<people[i]){
                ans+=right-left+1;
            }else {
                ans+=inp.peoples.get(i);
            }
            if(left-tmpRight-1>0){
                ans+=left-tmpRight-1;
            }
            tmpRight = right;
            if (i== merge.length-1){
                if (right<n){
                    ans+=n-right;
                }
            }
        }
        System.out.println(ans);

    }
}
