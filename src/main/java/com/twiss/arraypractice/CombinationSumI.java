package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumI {
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
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
            sol.add(candidates[i]);
            solver(candidates,target-candidates[i],i,sol,res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {3,2,7,6};
        List<List<Integer>> res = combinationSum(candidates,7);
        System.out.println(res);
    }
}
