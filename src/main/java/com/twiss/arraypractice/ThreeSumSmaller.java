package com.twiss.arraypractice;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for (int i = 0; i < n - 2; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target){
                    count += k-j;
                    j++;
                }else {
                    k--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        System.out.println(solution(nums,2));
    }
}
