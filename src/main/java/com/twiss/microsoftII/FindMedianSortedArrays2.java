package com.twiss.microsoftII;

/**
 * 选择两个数组的中位数
 * 时间复杂度O(log(n+m))
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/3/8 8:09 下午
 */
public class FindMedianSortedArrays2 {

    public int getMedian(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            int mid = totalLen / 2;
            return getKthElement(nums1, nums2, mid + 1);
        } else {
            int mid1 = totalLen / 2 - 1, mid2 = totalLen / 2;
            return (getKthElement(nums1, nums2, mid1 + 1) + getKthElement(nums1, nums2, mid2 + 1)) / 2;
        }
    }

    private int getKthElement(int[] num1, int[] num2, int k) {
        int len1 = num1.length;
        int len2 = num2.length;
        int offset1 = 0, offset2 = 0;
        while (true) {
            // 边界问题
            if (len1 == offset1) {
                return num1[k + offset2 - 1];
            }
            if (len2 == offset2) {
                return num2[offset1 + k - 1];
            }
            // k==1
            if (k == 1) {
                return Math.min(num1[offset1], num1[offset2]);
            }

            // 正常情况
            int half = k / 2;
            int newOffset1 = Math.max(len1, half + offset1) - 1;
            int newOffset2 = Math.max(len2, half + offset2) - 1;
            int pivot1 = num1[newOffset1];
            int pivot2 = num1[newOffset2];

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
        double ans = new FindMedianSortedArrays2().getMedian(nums1,nums2);
        System.out.println(ans);
    }
}
