package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

/**
 * 堆排序
 * 时间复杂度O(nlogn)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/5 2:07 下午
 */
public class HeapSorted {

    public int[] getSorted(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int len = nums.length - 1;
        // 构建堆
        buildMaxHeap(nums, len);
        // 遍历数组，将剩余的子顶堆进行重新排序
        for (int i = len; i >= 1; --i) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, i, 0);
            // 逐步减少堆有序的部分
            len -= 1;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            heapify(nums, 0, len);
        }
        return nums;
    }

    private void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; --i) {
            heapify(nums, i, len);
        }
    }

    private void heapify(int[] nums, int i, int len) {
        for (; (i << 1) + 1 <= len;) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {12, 44, 13, 88, 23, 94, 11, 39, 20, 16};
        int[] ans = new HeapSorted().getSorted(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
