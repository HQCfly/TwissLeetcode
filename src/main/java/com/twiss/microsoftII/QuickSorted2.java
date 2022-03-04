package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

import java.util.Random;

/**
 * 快排
 * 时间复杂度O(nlogn)
 *
 * @Author: Twiss
 * @Date: 2022/3/3 10:11 下午
 */
public class QuickSorted2 {

    public int[] getSortedArrays(int[] arrays) {
        if (arrays.length == 0) {
            return arrays;
        }
        randomizedQuicksort(arrays, 0, arrays.length - 1);
        return arrays;
    }

    public void randomizedQuicksort(int[] nums, int left, int right) {
        if (left < right) {
            int pos = randomizedPartition(nums, left, right);
            randomizedQuicksort(nums, left, pos - 1);
            randomizedQuicksort(nums, pos + 1, right);
        }
    }

    private int randomizedPartition(int[] nums, int left, int right) {
        int randomIndex = left + new Random().nextInt(right - left + 1);
        swap(nums, randomIndex, right);
        return partition(nums, left, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        // 慢指针标志
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
        int[] nums = {23, 19, 15, 7, 21, 6, 18};
        int[] ans = new QuickSorted2().getSortedArrays(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }

}
