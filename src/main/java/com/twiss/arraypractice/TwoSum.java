package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static List<Integer> findIndex(int[] numbers, int target){
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer,Integer> sumMap = new HashMap<>();
        int n = numbers.length;
        for (int i =0;i<n;++i){
            int temp = target - numbers[i];
            if (sumMap.containsKey(temp)){
                res.add(sumMap.get(temp));
                res.add(i);
                break;
            }
            sumMap.put(numbers[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        List<Integer> res = findIndex(numbers,target);
        System.out.println(res);
    }
}
