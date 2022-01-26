package com.twiss.microsoft;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2022/1/26 7:10 下午
 */
public class ThreeSum {

    public List<List<Integer>> getElementsOfThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> elements = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; ++i) {
            int j = i+1;
            int k = n-1;
            while (j<k){
                String key = String.format("%d,%d,%d",nums[i],nums[j],nums[k]);
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==0){
                    if (!elements.contains(key)){
                        elements.add(key);
                        List<Integer> sumOfKey = new ArrayList<>();
                        sumOfKey.add(nums[i]);
                        sumOfKey.add(nums[j]);
                        sumOfKey.add(nums[k]);
                        res.add(sumOfKey);
                    }
                    j++;
                    k--;
                } else if (sum<0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = new ThreeSum().getElementsOfThreeSum(nums);
        System.out.println(res);
    }
}
