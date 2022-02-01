package com.twiss.microsoft;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和
 * @Author: Twiss
 * @Date: 2022/2/1 2:37 下午
 */
public class CombinationSum {

    public List<List<Integer>> getCombinationSum(int[] candidates,int target){
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len==0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,res);
        return res;
    }

    private void dfs(int[] candidates,int begin, int len,
                     int target,Deque<Integer> path,List<List<Integer>> res){
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=begin;i<len;++i){
            if (target-candidates[i]<0){
                break;
            }
            // 添加候选元素
            path.addLast(candidates[i]);
            dfs(candidates,i,len,target-candidates[i],path,res);
            // 状态重置
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new CombinationSum().getCombinationSum(candidates,target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
