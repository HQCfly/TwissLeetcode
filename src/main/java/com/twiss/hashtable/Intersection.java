package com.twiss.hashtable;

import com.alibaba.fastjson.JSONObject;

import java.util.HashSet;
import java.util.Set;

/**
 * 两数组的交集
 * @Author: Twiss
 * @Date: 2022/6/2 12:28 下午
 */
public class Intersection {

    public int[] getIntersection(int[] nums1,int[] nums2){
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i:nums1){
            set1.add(i);
        }
        for (int i:nums2){
            if (set1.contains(i)){
                resSet.add(i);
            }
        }

        int[] res = new int[resSet.size()];
        int idx = 0;
        for (int i:resSet){
            res[idx++] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans = new Intersection().getIntersection(nums1,nums2);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
