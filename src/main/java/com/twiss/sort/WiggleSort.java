package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/11/22 11:01 下午
 */
public class WiggleSort {

    public int[] getWiggleSorted(int[] numbers){
        Arrays.sort(numbers);
        if (numbers.length<=2){
            return numbers;
        }
        for (int i=2;i<numbers.length;i+=2){
            swap(numbers,i,i-1);
        }
        return numbers;
    }

    private void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 5, 1, 1, 6, 4};
        int[] res = new WiggleSort().getWiggleSorted(numbers);
        System.out.println(JSONObject.toJSONString(res));
    }
}
