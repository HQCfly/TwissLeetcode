package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 两数和
 *
 * @Author: Twiss
 * @Date: 2022/3/17 1:59 下午
 */
public class TwoSum {

    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[]  getSum(int[] nums,int target){
        for (int i=0;i<nums.length-1;++i){
            for (int j=i+1;j<nums.length;++j){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    public int[] getSumByHashTable(int[] nums,int target){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums.length;++i){
            if (hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums= {2,7,11,15}; int target = 9;
        int[] ans = new TwoSum().getSum(nums,target);
        System.out.println(JSONObject.toJSONString(ans));

        int[] ans2 = new TwoSum().getSumByHashTable(nums,target);
        System.out.println(JSONObject.toJSONString(ans2));
    }
}
