package com.twiss.hashtable;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @Author: Twiss
 * @Date: 2022/6/4 3:49 下午
 */
public class ThreeSum {

    public List<List<Integer>> getNums(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null||nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                return ans;
            }
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum>0){
                    right--;
                }else if (sum<0){
                    left++;
                }else {
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (right>left&&nums[right]==nums[right-1]){
                        right--;
                    }
                    while (right>left&&nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = new ThreeSum().getNums(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
