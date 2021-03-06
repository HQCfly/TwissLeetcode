package com.twiss.arraypractice;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<String> sumKey = new HashSet<String>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; ++i) {
            for (int j = i + 1; j < n - 2; ++j) {
                int m = i + 1;
                int k = n - 1;
                while (m < k) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[k];
                    if (sum == target) {
                        String key = String.format("%d,%d,%d,%d", nums[i], nums[j], nums[m], nums[k]);
                        if (!sumKey.contains(key)) {
                            sumKey.add(key);
                            List<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[m]);
                            tmp.add(nums[k]);
                            res.add(tmp);
                        }
                        m++;
                        k--;
                    } else if (sum < target) {
                        m++;
                    } else {
                        k--;
                    }
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        solution(nums, 0);
    }
}
