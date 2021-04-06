package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/6 9:39 下午
 */
public class RotateArray {

    public static int[] getRotateArrayInExtraSpace(int[] numbers, int k) {
        int n = numbers.length;
        int[] newArray = new int[n];
        for (int i = 0; i < newArray.length; ++i) {
            newArray[(i + k) % n] = numbers[i];
        }
        System.arraycopy(newArray, 0, numbers, 0, n);
        return numbers;
    }

    public static int[] getRotateArrayInRotate(int[] numbers, int k) {
        int n = numbers.length - 1;
        int j = k % n;
        reverse(numbers, 0, n);
        reverse(numbers, 0, j - 1);
        reverse(numbers, j, n);
        return numbers;
    }

    public static void reverse(int[] numbers, int start, int end) {
        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] res = getRotateArrayInExtraSpace(numbers, k);
        System.out.println(JSONObject.toJSONString(res));
        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7};
        int k2 = 3;
        int[] res2 = getRotateArrayInRotate(numbers2, k2);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
