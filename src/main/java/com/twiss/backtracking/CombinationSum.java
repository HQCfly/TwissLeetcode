package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/13 9:44 下午
 */
public class CombinationSum {
    private List<List<Integer>> getCombinationSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getTargetNumbers(numbers,target,0,new ArrayList<Integer>(),res);
        return res;
    }

    private void getTargetNumbers(int[] numbers, int target, int index, List<Integer> sol, List<List<Integer>> res) {
        // 满足要求的递归出口
        if (target == 0) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        // 非要求递归出口
        if (target < 0 || index == numbers.length) {
            return;
        }
        for (int i = index; i < numbers.length; i++) {

            // 先加入sol中通过getTargetNumbers方法判断是否是要求的num
            sol.add(numbers[i]);
            // 递归调用下一层num，包括当前元素
            getTargetNumbers(numbers,target-numbers[i],i,sol,res);
            // 针对以上返回，清除符合（符合要求的已存入res中）或者不符合要求的。
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,6,7};
        int target = 7;
        List<List<Integer>> res = new CombinationSum().getCombinationSum(numbers, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
