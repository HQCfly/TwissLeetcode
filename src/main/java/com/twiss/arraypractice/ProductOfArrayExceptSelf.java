package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/1 8:43 下午
 */
public class ProductOfArrayExceptSelf {

    public static int[] getProductOfArrayExceptSelf(int[] numbers) {
        int length = numbers.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] ans = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i-1]*numbers[i-1];
        }
        right[length-1] = 1;
        for (int i = length-2;i>=0;i--){
            right[i] = right[i+1]*numbers[i+1];
        }
        for (int i = 0; i < length; i++) {
            ans[i] = left[i]*right[i];
        }
        return ans;

    }

    public static int[] getProductOfArrayExceptSelf2(int[] numbers) {
        int length = numbers.length;
        int[] ans = new int[length];
        ans[0] = 1;
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i-1]*numbers[i-1];
        }

        int right = 1;
        for (int i = length-1;i>=0;i--){
            ans[i] = ans[i]*right;
            right *= numbers[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] res = getProductOfArrayExceptSelf(numbers);
        System.out.println(JSONObject.toJSONString(res));

        int[] res2 = getProductOfArrayExceptSelf2(numbers);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
