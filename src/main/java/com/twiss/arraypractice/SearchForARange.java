package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;


/**
 * @Author: Twiss
 * @Date: 2021/4/9 10:10 下午
 */
public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        int upper = upperOrLower(nums, target, true);
        int lower = upperOrLower(nums, target, false);
        return new int[]{lower,upper};
    }

    private static int upperOrLower(int[] nums, int target, boolean upper){
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target){
                res = mid;
                if(upper){
                    left = mid + 1;
                }else right = mid - 1;
            }
            else if(nums[mid] > target) right = mid -1;
            else left = mid + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] res = searchRange(numbers, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
