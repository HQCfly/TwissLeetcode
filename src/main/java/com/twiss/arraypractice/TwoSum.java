package com.twiss.arraypractice;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {

    public static List<Integer> findIndex(int[] numbers, int target){
        List<Integer> res = new ArrayList<Integer>();
        int i = 0, j = numbers.length-1;
        while (i<j){
            int sum = numbers[i]+numbers[j];
            if (sum==target){
                res.add(i);
                res.add(j);
                break;
            }
            if (sum<target){
                i++;
            } else {
                j--;
            }
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
