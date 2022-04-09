package com.twiss.zijie;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * 时间复杂度O(nLogn)
 * 空间复杂度O(logn)
 *
 * @Author: Twiss
 * @Date: 2022/4/7 8:29 下午
 */
public class QuickSorted {

    public int[] getQuickSorted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length - 1;
        randomQuick(nums, 0, n);
        return nums;
    }

    private void randomQuick(int[] nums, int left, int right) {
        if (left < right) {
            int index = randomPartition(nums, left, right);
            randomQuick(nums, left, index - 1);
            randomQuick(nums, index + 1, right);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int pivotIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, pivotIndex, right);
        int pivot = nums[right];
        int j = left - 1;
        for (int i = left; i <= right - 1; i++) {
            if (nums[i] <= pivot) {
                j = j + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, j + 1, right);
        return j + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] ans = new QuickSorted().getQuickSorted(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
