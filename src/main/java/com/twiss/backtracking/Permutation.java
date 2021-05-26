package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/5/26 7:07 下午
 */
public class Permutation {

    private List<List<Integer>> getPermutation(int[] numbers) {
        int n = numbers.length;
        boolean[] used = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        backtrace(n,0,used,numbers,new ArrayList<>(),ans);
        return ans;
    }

    private void backtrace(int n, int index, boolean[] used, int[] numbers, List<Integer> sol, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(sol));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            sol.add(numbers[i]);
            used[i] = true;
            backtrace(n, index + 1, used, numbers, sol, ans);
            used[i] = false;
            sol.remove(sol.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        List<List<Integer>> ans = new Permutation().getPermutation(numbers);
        System.out.println(JSONObject.toJSONString(ans));
    }

}
