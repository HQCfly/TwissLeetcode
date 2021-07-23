package com.twiss.binarysearch;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/7/22 4:08 下午
 */
public class IntersectionOfTwoArraysII {

    private int[] getIntersectionByHash(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num:nums1){
            int count = map.getOrDefault(num,0)+1;
            map.put(num,count);
        }

        int index = 0;
        int[] intersection = new int[nums1.length+nums2.length];
        for (int num:nums2){
            int count = map.getOrDefault(num,0);
            if (count>0){
                intersection[index++] = num;
                count--;
                if (count>0){
                    map.put(num,count);
                }else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection,0,index);
    }


    private int[] getIntersectionByBinarySearch(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length+length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1<length&&index2<length2){
            int number1 = nums1[index1], number2 = nums2[index2];
            if (number1==number2){
                intersection[index++] = number1;
                index1++;
                index2++;
            } else if (number1<number2){
                index1++;
            } else {
                index2++;
            }
        }

        return Arrays.copyOfRange(intersection,0,index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = new IntersectionOfTwoArraysII().getIntersectionByHash(nums1,nums2);
        System.out.println(JSONObject.toJSONString(res));

        int[] nums11 = {4,9,5,9};
        int[] nums12 = {9,4,9,8,4};
        int[] res2 = new IntersectionOfTwoArraysII().getIntersectionByHash(nums11,nums12);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
