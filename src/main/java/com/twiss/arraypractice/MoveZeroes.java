package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;


/**
 * @Author: Twiss
 * @Date: 2021/3/28 8:18 下午
 */
public class MoveZeroes {

    public static int[] solved(int[] numbers) {
        int n = numbers.length, left = 0, right = 0;
        while (right<n){
            if (numbers[right]!=0){
                swap(numbers,left,right);
                left++;
            }
            right++;
        }
        return numbers;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12};
        int[] res = solved(numbers);
        System.out.println(JSONObject.toJSONString(res));
    }
}
