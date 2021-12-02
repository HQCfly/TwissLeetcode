package com.twiss.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/12/2 3:57 下午
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */
public class ShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0, minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                maxNum = arr[0];
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        int res = new ShortestSubArray().findShortestSubArray(nums);
        System.out.println(res);
    }
}
