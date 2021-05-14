package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/13 9:44 下午
 */
public class CombinationSumIII {
    private List<List<Integer>> getCombinationSum(int numberOfRes, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        getTargetNumbers(numberOfRes,target,1,new ArrayList<Integer>(),res);
        return res;
    }

    private void getTargetNumbers(int numberOfRes, int target, int index, List<Integer> sol, List<List<Integer>> res) {
        // 满足要求的递归出口
        if (target == 0 && sol.size()==numberOfRes) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        // 非要求递归出口
        if (target < 0 || index > 9 || sol.size() > numberOfRes) {
            return;
        }
        for (int i = index; i < 10; i++) {

            // 先加入sol中通过getTargetNumbers方法判断是否是要求的num
            sol.add(i);
            // 递归调用下一层num
            getTargetNumbers(numberOfRes,target-i,i+1,sol,res);
            // 针对以上返回，清除符合（符合要求的已存入res中）或者不符合要求的。
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int numberOfRes = 3;
        int target = 9;
        List<List<Integer>> res = new CombinationSumIII().getCombinationSum(numberOfRes, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
