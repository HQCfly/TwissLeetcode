package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * 两数和
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 *
 * @Author: Twiss
 * @Date: 2022/4/2 8:29 下午
 */
public class TwoSum {

    public int[] getSum(int[] nums,int target) {
        if (nums == null) {
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;++i){
            int tmp = target-nums[i];
            if (map.containsKey(tmp)){
                return new int[]{i,map.get(tmp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = new TwoSum().getSum(nums,target);
        System.out.println(JSONObject.toJSONString(ans));
    }

}
