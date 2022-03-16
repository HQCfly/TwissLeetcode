package com.twiss.microsoftII;

/**
 * 两个数组中寻找中位数
 * 时间复杂度O(log(m+n))
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/16 7:07 下午
 */
public class FindMedianSortedArrays3 {

    public int getMedia(int[] array1, int[] array2) {
        int len1 = array1.length;
        int len2 = array2.length;
        int total = len1 + len2;

        if (total % 2 == 1) {
            int midIndex = total / 2;
            return getKthElement(array1, array2, midIndex + 1);
        } else {
            int left = total / 2 - 1;
            int right = total / 2;
            return (getKthElement(array1, array2, left + 1) +
                    getKthElement(array1, array2, right + 1)) / 2;
        }
    }

    private int getKthElement(int[] array1, int[] array2, int k) {
        int len1 = array1.length;
        int len2 = array2.length;
        int offset1 = 0, offset2 = 0;
        while (true) {
            // 边界问题
            if (len1 == offset1) {
                return array1[k + offset2 - 1];
            }
            if (len2 == offset2) {
                return array2[k + offset1 - 1];
            }
            if (k == 1) {
                return Math.min(array1[offset1], array2[offset2]);
            }
            // 正常情况
            int half = k / 2;
            int newOffset1 = Math.min(len1, half + offset1) - 1;
            int newOffset2 = Math.min(len2, half + offset2) - 1;
            int pivot1 = array1[newOffset1];
            int pivot2 = array2[newOffset2];
            if (pivot1 <= pivot2) {
                k -= (offset1 - newOffset1) + 1;
                offset1 = newOffset1 + 1;
            } else {
                k -= (offset2 - newOffset2) + 1;
                offset2 = newOffset2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        int ans = new FindMedianSortedArrays3().getMedia(nums1, nums2);
        System.out.println(ans);
    }
}
