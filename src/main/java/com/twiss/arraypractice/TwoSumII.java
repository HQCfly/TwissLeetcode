package com.twiss.arraypractice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/4/25 8:12 下午
 */
public class TwoSumII {

    public static int[] getElementsIndex(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
        int[] res = new int[2];
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] res = getElementsIndex(numbers, target);
        System.out.println(JSONObject.toJSONString(res));
    }
}
