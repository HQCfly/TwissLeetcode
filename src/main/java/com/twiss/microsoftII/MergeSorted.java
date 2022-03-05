package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/4 11:50 下午
 */
public class MergeSorted {

    private int[] tmp;

    public int[] getSortedNums(int[] nums) {
        tmp = new int[nums.length];
        mergeSortedNumbers(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSortedNumbers(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (right + left) >> 1;
        mergeSortedNumbers(nums, left, mid);
        mergeSortedNumbers(nums, mid + 1, right);
        // 合并操作
        int i = left, j = mid + 1;
        int cnt = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        // 对于left数组未添加完成的，继续往临时数组中添加
        while (i <= mid) {
            tmp[cnt++] = nums[i++];
        }

        // 对于right数组未添加完成的，继续往临时数组中添加
        while (j <= right) {
            tmp[cnt++] = nums[j++];
        }

        // 将tmp数组与原数组进行交换
        for (int k = 0; k < right - left + 1; k++) {
            nums[k + left] = tmp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int[] ans = new MergeSorted().getSortedNums(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
