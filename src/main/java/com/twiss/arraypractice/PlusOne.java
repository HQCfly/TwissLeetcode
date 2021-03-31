package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/3/31 8:37 下午
 */
public class PlusOne {

    public static int[] getPlusOne(int[] numbers){
        int n = numbers.length;
        for (int i = n - 1; i >= 0; i--){
            numbers[i]++;
            numbers[i]%=10;
            if (numbers[i]%10!=0){
                return numbers;
            }
        }
        numbers = new int[numbers.length+1];
        numbers[0] = 1;
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {4,3,9,9};
        int[] res = getPlusOne(numbers);
        System.out.println(JSONObject.toJSONString(res));
    }
}
