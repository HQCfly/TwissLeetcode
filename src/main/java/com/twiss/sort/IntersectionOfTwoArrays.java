package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/10/23 10:40 下午
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] arrays1, int[] arrays2) {
        Arrays.sort(arrays1);
        Arrays.sort(arrays2);
        int len1 = arrays1.length, len2 = arrays2.length;
        int[] intersection = new int[len1 + len2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < len1 && index2 < len2) {
            int num1 = arrays1[index1], num2 = arrays2[index2];
            if (num1 == num2) {
                // 保证元素唯一
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = new IntersectionOfTwoArrays().intersection(nums1, nums2);
        System.out.println(JSONObject.toJSONString(res));
    }

}
