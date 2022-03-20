package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * 时间复杂度O()
 * 空间复杂度O()
 * @Author: Twiss
 * @Date: 2022/3/19 6:25 下午
 */
public class CombinationSum2 {

    public List<List<Integer>> getSum(int[] nums,int target){
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null){
            return ans;
        }
        backtracking(nums,target,0,new ArrayList<Integer>(),ans);
        return ans;
    }

    private void backtracking(int[] nums, int target,
                              int ith,List<Integer> tmp,
                              List<List<Integer>> ans){
        if (ith==nums.length){
            return;
        }
        if (target==0){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        backtracking(nums,target,ith+1,tmp,ans);
        if (target-nums[ith]>=0){
            tmp.add(nums[ith]);
            backtracking(nums,target-nums[ith],ith,tmp,ans);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = new CombinationSum2().getSum(nums,target);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
