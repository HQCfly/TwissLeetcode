package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/13 9:44 下午
 */
public class CombinationSumII {
    private List<List<Integer>> getCombinationSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(numbers);
        /**
         * 搜索树如下
         *            1       2
         *         / |  \     |
         *        1  2  7     6
         *       /   |
         *      6    5
         *      每次都搜索到底，然后在最底层搜完，再搜上一层
         */
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
            if (i > index && numbers[i - 1] == numbers[i]) {
                continue;
            }
            // 先加入sol中通过getTargetNumbers方法判断是否是要求的num
            sol.add(numbers[i]);
            // 递归调用下一层num
            getTargetNumbers(numbers,target-numbers[i],i+1,sol,res);
            // 针对以上返回，清除符合（符合要求的已存入res中）或者不符合要求的。
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = new CombinationSumII().getCombinationSum(numbers, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
