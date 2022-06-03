package com.twiss.hashtable;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数和
 * @Author: Twiss
 * @Date: 2022/6/3 4:33 下午
 */
public class TwoSum {

    public int[] getSum(int[] nums, int target){

        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int tmp = target-nums[i];
            if (map.containsKey(tmp)){
                res[0] = i;
                res[1] = map.get(tmp);
            }
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new TwoSum().getSum(nums,target);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
