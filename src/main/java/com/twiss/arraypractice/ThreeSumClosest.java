package com.twiss.arraypractice;

import java.util.*;

public class ThreeSumClosest {
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 1; i < n - 2; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target){
                    return closest;
                }
                else if (sum>target){
                    k--;
                }else {
                    j++;
                }
                if (Math.abs(sum - target)<Math.abs(closest-target)){
                    closest = sum;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        solution(nums,1);
    }
}
