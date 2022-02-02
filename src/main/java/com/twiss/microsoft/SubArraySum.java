package com.twiss.microsoft;

import java.util.HashMap;

/**
 * 和为k的子数组
 * 将前缀和都扔到map中，然后查询是否存在pre-k的前缀和，如果有则count++
 * @Author: Twiss
 * @Date: 2022/2/2 3:12 下午
 */
public class SubArraySum {

    public int getSubArray(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 7, 2, -3, 1, 4, 2};
        int k = 2;
        int res = new SubArraySum().getSubArray(nums, k);
        System.out.println(res);
    }
}
