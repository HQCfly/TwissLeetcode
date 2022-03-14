package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/6 3:59 下午
 */
public class QuickSorted3 {

    public int[] getSorted(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        quickSortedNums(nums, 0, n - 1);
        return nums;
    }

    private void quickSortedNums(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomPartition(nums, left, right);
            quickSortedNums(nums, left, pos - 1);
            quickSortedNums(nums, pos + 1, right);
        }
    }

    private int randomPartition(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        int pivot = nums[randomIndex];
        int i = left - 1;
        for (int j = left; j <= right - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        int[] ans = new QuickSorted3().getSorted(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
