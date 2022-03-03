package com.twiss.microsoftII;

/**
 * 寻找两个有序数组中位数
 * 时间复杂度O(log(n+m))
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/3 8:36 下午
 */
public class FindMedianSortedArray2 {

    public double findMedian(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        // 奇数
        if (totalLen % 2 == 1) {
            int medianIndex = totalLen / 2;
            return getKthElement(nums1, nums2, medianIndex + 1);
        } else {
            int medianIndex1 = totalLen / 2 - 1, medianIndex2 = totalLen / 2;
            return (getKthElement(nums1, nums2, medianIndex1 + 1) +
                    getKthElement(nums1, nums2, medianIndex2 + 1)) / 2;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int offset1 = 0, offset2 = 0;
        while (true) {
            // 边界问题
            if (offset1 == len1) {
                return nums1[offset2 + k - 1];
            }
            if (offset2 == len2) {
                return nums2[offset1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[offset1], nums2[offset2]);
            }
            // 正常情况
            int half = k / 2;
            // len是总长度，对应下标所以要减去1
            int newOffset1 = Math.min(len1, offset1 + half) - 1;
            int newOffset2 = Math.min(len2, offset2 + half) - 1;
            int pivot1 = nums1[newOffset1];
            int pivot2 = nums2[newOffset2];
            if (pivot1 <= pivot2) {
                // 数量，加1
                k -= (offset1 - newOffset1) + 1;
                offset1 = newOffset1 + 1;
            } else {
                k -= (offset2 - newOffset1) + 1;
                offset2 = newOffset2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double ans = new FindMedianSortedArray2().findMedian(nums1, nums2);
        System.out.println(ans);
    }
}
