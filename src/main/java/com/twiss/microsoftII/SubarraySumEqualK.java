package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * 和为k的子数组
 * 前缀和
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/2/24 3:13 下午
 */
public class SubarraySumEqualK {

    public int getNumsOfSumK(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; ++i) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count++;
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        int res = new SubarraySumEqualK().getNumsOfSumK(nums,k);
        System.out.println(res);
    }
}
