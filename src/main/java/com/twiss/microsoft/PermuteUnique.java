package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * 全排列
 *
 * @Author: Twiss
 * @Date: 2022/1/25 2:40 下午
 */
public class PermuteUnique {

    public List<List<Integer>> getPermute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序，剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len,
                     int depth, boolean[] used,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        // 递归出口
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 全排列
        for (int i = 0; i < len; ++i) {
            if (used[i]){
                continue;
            }
            // 剪枝
            if (i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,used,path,res);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> res = new PermuteUnique().getPermute(nums);
        System.out.println(JSONObject.toJSONString(res));
    }
}
