package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * 不需要保证数组唯一
 * @Author: Twiss
 * @Date: 2021/10/24 10:21 下午
 */
public class IntersectionOfTwoArraysII {

    public int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res=  new IntersectionOfTwoArraysII().intersection(nums1,nums2);
        System.out.println(JSONObject.toJSONString(res));
    }
}
