package com.twiss.binarysearch;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/8/4 1:56 下午
 */
public class SearchForARange {

    private int[] searchRange(int[] arrays, int target) {
        int n = arrays.length;
        if (n == 0 || arrays == null) {
            return new int[]{-1, -1};
        }
        int lowIndex = lower(arrays, target, 0, n - 1);
        if (lowIndex == -1) {
            return new int[]{-1, -1};
        }
        int highIndex = upper(arrays, target, 0, n - 1);
        return new int[]{lowIndex, highIndex};
    }

    private int lower(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)){
            return mid;
        }

        if (nums[mid] >= target) {
            return lower(nums, target, lo, mid - 1);
        } else {
            return lower(nums, target, mid + 1, hi);
        }
    }

    private int upper(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target && (mid == nums.length - 1 || target
                < nums[mid + 1])) {
            return mid;
        }
        if (nums[mid] <= target) {
            return upper(nums, target, mid + 1, hi);
        } else {
            return upper(nums, target, lo, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arrays = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = new SearchForARange().searchRange(arrays, target);
        System.out.println(JSONObject.toJSONString(res));
    }

}
