package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/17 7:54 下午
 */
public class FactorCombinations {

    private List<List<Integer>> getFactorCombinations(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n,2,new ArrayList<Integer>(),res);
        return res;
    }

    private void helper(int n, int index, List<Integer> sol, List<List<Integer>> res) {
        if (n == 1) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        for (int i = index; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sol.add(i);
                helper(n/i,i,sol,res);
                sol.remove(sol.size()-1);
            }
        }
        sol.add(n);
        helper(1,n,sol,res);
        sol.remove(sol.size()-1);
    }

    public static void main(String[] args) {
        int n = 8;
        List<List<Integer>> res = new FactorCombinations().getFactorCombinations(n);
        System.out.println(JSONObject.toJSONString(res));
    }
}
