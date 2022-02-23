package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 * https://leetcode-cn.com/problems/permutations-ii/solution/quan-pai-lie-ii-by-leetcode-solution/
 * 时间复杂度O(n*n!)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/2/23 8:15 下午
 */
public class PermuteUnique {

    private boolean[] visited;

    public List<List<Integer>> getPermuteUnique(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> unique = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0,unique,ans);
        return ans;
    }

    private void backtrack(int[] nums,int index, List<Integer> unique, List<List<Integer>> ans){
        if (index==nums.length){
            ans.add(new ArrayList<Integer>(unique));
            return;
        }

        for (int i=0;i<nums.length;++i){
            if ((visited[i])||(i>0&&nums[i]==nums[i-1]&&!visited[i-1])){
                continue;
            }
            unique.add(nums[i]);
            visited[i] = true;
            backtrack(nums,index+1,unique,ans);
            visited[i] = false;
            unique.remove(index);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> ans = new PermuteUnique().getPermuteUnique(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
