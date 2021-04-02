package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/2 10:31 下午
 */
public class RangeAddition {

    public static int[] getRangeAddition(int length, int[][] updates) {
        int[] res = new int[length];
        for (int i = 0; i < updates.length; ++i) {
            int start = updates[i][0];
            int end = updates[i][1];
            int number = updates[i][2];
            res[start] += number;
            if (end < length - 1) {
                res[end + 1] -= number;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            res[i] += sum;
            sum = res[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] res = getRangeAddition(length, updates);
        System.out.println(JSONObject.toJSONString(res));
    }
}
