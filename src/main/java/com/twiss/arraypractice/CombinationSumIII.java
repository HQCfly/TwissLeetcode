package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSumIII(int candidateNumbers, int target){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solver(candidateNumbers,target,1,new ArrayList<Integer>(), res);
        return res;
    }

    private static void solver(int candidateNumbers, int target, int index, List<Integer> sol, List<List<Integer>> res){
        if (target == 0 && sol.size()==candidateNumbers){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        if (target < 0 || index > 9){
            return;
        }

        for (int i = index;i<=9;i++){
            sol.add(i);
            solver(candidateNumbers,target-i,i+1,sol,res);
            sol.remove(sol.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSumIII(3,9);
        System.out.println(res);
    }
}
