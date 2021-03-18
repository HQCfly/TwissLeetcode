package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/3/17 9:22 下午
 */
public class MergeSortedArray {

    public static int[] merger(int[] numbers1, int m, int[] number2, int n) {
        int[] numbers1Copy = new int[m];
        System.arraycopy(numbers1, 0, numbers1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            numbers1[p++] = (numbers1Copy[p1] < number2[p2]) ? numbers1Copy[p1++] : number2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(numbers1Copy, p1, numbers1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(number2, p2, numbers1, p1 + p2, m + n - p1 - p2);
        }
        return numbers1;
    }

    public static int[] merger2(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }

    public static void main(String[] args) {
        int[] number1 = {1, 2, 3, 0, 0, 0};
        int[] number2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        int[] res = merger(number1, m, number2, n);
        System.out.println(JSONObject.toJSONString(res));

        int[] number11 = {1, 2, 3, 0, 0, 0};
        int[] number22 = {2, 5, 6};
        int m1 = 3;
        int n1 = 3;
        int[] res2 = merger2(number11, m1, number22, n1);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
