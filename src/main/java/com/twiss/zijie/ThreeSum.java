package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 三数之和
 * 时间复杂度O(N^2)
 * 空间复杂度O(N)
 * @Author: Twiss
 * @Date: 2022/4/3 8:06 下午
 */
public class ThreeSum {

    public List<List<Integer>> getSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;++i){
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                String st = String.format("%d,%d,%d",nums[i],nums[j],nums[k]);
                if (sum==target){
                    if (!set.contains(st)){
                        List<Integer> list = new ArrayList<>();
                        set.add(st);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        ans.add(new ArrayList<>(list));
                    }
                    j++;
                    k--;
                }else if (sum<target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        int target = 0;
        List<List<Integer>> ans = new ThreeSum().getSum(nums,target);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
