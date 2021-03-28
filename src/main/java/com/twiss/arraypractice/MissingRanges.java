package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/3/28 7:43 下午
 */
public class MissingRanges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        if (nums==null||nums.length==0){
            res.add(getRange(lower,upper));
            return res;
        }

        int pre = lower-1, curr = 0;
        for (int i =0;i<=nums.length;++i){
            curr = i==nums.length?upper+1:nums[i];
            if (curr-pre>1){
                res.add(getRange(pre+1,curr-1));
            }
            pre = curr;
        }
        return res;
    }

    private static String getRange(int from, int to){
        return from==to?String.valueOf(from):from+"->"+to;
    }

    public static void main(String[] args) {
        int[] numbers = {0,1,3,50,75};
        int lower = 0, upper = 99;
        List<String> res = findMissingRanges(numbers,lower,upper);
        System.out.println(JSONObject.toJSONString(res));
    }
}
