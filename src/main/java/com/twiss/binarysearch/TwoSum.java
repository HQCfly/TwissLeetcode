package com.twiss.binarysearch;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/8/9 8:17 下午
 */
public class TwoSum {

    public int[] getIndex(int[] array, int target) {
        int l = 0, h = array.length - 1;
        while (l<=h){
            int mid = l+(h-l)/2;
            int tmp = target-array[l];
            if (array[mid]==tmp){
                return new int[]{l,mid};
            }else if (array[mid]<tmp){
                l = mid+1;
            }else {
                h = mid-1;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] res = new TwoSum().getIndex(array, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
