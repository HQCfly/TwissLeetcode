package com.twiss.microsoftII;

/**
 * 寻找两个排序数组的中位数
 * 时间复杂度O(log(m+n))
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/3/2 10:12 下午
 */
public class FindMedianSortedArrays {

    public double getFindMedian(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int totalLen = len1+len2;
        if (totalLen%2==1){
            int midIndex = totalLen/2;
            return getKthElement(nums1,nums2,midIndex+1);
        }else {
            int midIndex1 = totalLen/2-1, midIndex2 = totalLen/2;
            return (getKthElement(nums1,nums2,midIndex1+1)+
                    getKthElement(nums1,nums2,midIndex2+1))/2;
        }
    }

    public double getKthElement(int[] nums1,int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int offset1 = 0, offset2 = 0;
        while (true){
            // 边界问题
            // num1长
            if (offset1 == len1){
                return nums1[offset2+k-1];
            }
            // num2长
            if (offset2==len2){
                return nums2[offset1+k-1];
            }
            // k==1
            if (k==1){
                return Math.min(nums1[offset1],nums2[offset2]);
            }
            // 正常情况
            int half = k/2;
            int newOffset1 = Math.min(offset1+half,len1)-1;
            int newOffset2 = Math.min(offset2+half,len2)-1;

            int pivot1 = nums1[newOffset1], pivot2 = nums2[newOffset2];
            if (pivot1<=pivot2){
                k-=(offset1-newOffset1)+1;
                offset1 = newOffset1+1;
            }else {
                k-=(offset2-newOffset2)+1;
                offset1 = newOffset2+1;
            }
        }

    }

    public static void main(String[] args) {

    }
}
