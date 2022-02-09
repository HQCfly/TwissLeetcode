package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2022/2/9 7:47 下午
 */
public class TwoSum {

    public List<Integer> getSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n - 2; ++i) {
            int last = n - 1;
            while (i < last) {
                int sum = nums[i] + nums[last];
                if (sum == target) {
                    res.add(i);
                    res.add(last);
                }
                last--;
            }
        }
        return res;
    }

    public List<Integer> getSumByHashTable(int[] nums,int target) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target-nums[i];
            if (hashMap.containsKey(tmp)){
                res.add(i);
                res.add(hashMap.get(tmp));
                break;
            }
            hashMap.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        List<Integer> res = new TwoSum().getSum(nums, target);
        System.out.println(JSONObject.toJSONString(res));

        int[] nums2 = {3, 3};
        int target2 = 6;
        List<Integer> res2 = new TwoSum().getSumByHashTable(nums2, target2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
