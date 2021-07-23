package com.twiss.binarysearch;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/7/22 4:08 下午
 */
public class IntersectionOfTwoArrays {

    private int[] getIntersectionByHash(int[] nums1, int[] nums2){
        Set<Integer> numsSet1 = new HashSet<Integer>();
        Set<Integer> numsSet2 = new HashSet<Integer>();
        for (int num : nums1){
            numsSet1.add(num);
        }
        for (int num: nums2){
            numsSet2.add(num);
        }
        return getIntersectionNums(numsSet1,numsSet2);
    }

    private int[] getIntersectionNums(Set<Integer> set1, Set<Integer> set2){

        if (set1.size()<set2.size()){
            return getIntersectionNums(set2,set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num:set1){
            if (set2.contains(num)){
                intersectionSet.add(num);
            }
        }

        int[] intersection = new int[intersectionSet.size()];
        int index= 0;
        for (int num:intersectionSet){
            intersection[index]=num;
            index++;
        }
        return intersection;
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
                if (index==0||number1!=intersection[index-1]){
                    intersection[index++] = number1;
                }
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
        int[] res = new IntersectionOfTwoArrays().getIntersectionByHash(nums1,nums2);
        System.out.println(JSONObject.toJSONString(res));

        int[] nums11 = {4,9,5};
        int[] nums12 = {9,4,9,8,4};
        int[] res2 = new IntersectionOfTwoArrays().getIntersectionByHash(nums11,nums12);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
