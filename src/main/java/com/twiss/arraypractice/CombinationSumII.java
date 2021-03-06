package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static List<List<Integer>> combinationSumII(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solver(candidates,target,0,new ArrayList<Integer>(), res);
        return res;
    }

    private static void solver(int[] candidates, int target, int index, List<Integer> sol, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (target < 0 || index == candidates.length){
            return;
        }

        for (int i=index;i<candidates.length;i++){
            if (i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            sol.add(candidates[i]);
            solver(candidates,target-candidates[i],i+1,sol,res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSumII(candidates,8);
        System.out.println(res);
    }
}
