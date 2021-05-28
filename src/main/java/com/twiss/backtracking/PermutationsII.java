package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/28 9:22 下午
 */
public class PermutationsII {
    public static void main(String[] args) {
        int[] number = {1, 1, 2};
        List<List<Integer>> res = new PermutationsII().getPermutation(number);
        System.out.println(JSONObject.toJSONString(res));
    }

    private List<List<Integer>> getPermutation(int[] number) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = number.length;
        boolean[] used = new boolean[n];
        backtrace(n, 0, number, used, new ArrayList<Integer>(), res);
        return res;
    }

    private void backtrace(int n, int index, int[] number, boolean[] used, List<Integer> sol, List<List<Integer>> res) {
        if (n == index) {
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 当前的number与i-1所表示的元素一致时候则需要跳过处理
            // !used[i-1]表示之前的以i-1为首的元素排列已经排列完毕
            if (i > 0 && number[i] == number[i - 1] && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                used[i] = true;
                sol.add(number[i]);
                backtrace(n, index + 1, number, used, sol, res);
                used[i] = false;
                sol.remove(sol.size() - 1);
            }
        }
    }
}
