package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/15 8:48 下午
 */
public class Combinations {

    public List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> sol, List<List<Integer>> res) {
        if (sol.size() == k ) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (index > n - k + 1) {
            return;
        }

        for (int i = index; i <= n; i++) {
            if ((sol.size() > 0 && i == sol.get(0))) {
                continue;
            }
            sol.add(i);
            dfs(n, k, i + 1, sol, res);
            sol.remove(sol.size() - 1);
        }
    }


    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> res = new Combinations().getCombinations(n, k);
        System.out.println(JSONObject.toJSONString(res));
    }
}
