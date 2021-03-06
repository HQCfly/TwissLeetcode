package com.twiss.arraypractice;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<String> sumKey = new HashSet<String>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    String key = String.format("%d,%d,%d", nums[i], nums[j], nums[k]);
                    if (!sumKey.contains(key)) {
                        sumKey.add(key);
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        res.add(tmp);
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        solution(nums);
    }
}
