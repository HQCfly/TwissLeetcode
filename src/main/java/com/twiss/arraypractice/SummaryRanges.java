package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Twiss
 * @Date: 2021/4/21 8:34 下午
 */
public class SummaryRanges {

    public static List<String> getRanges(int[] numbers) {
        List<String> res = new ArrayList<>();
        int n = numbers.length;
        int left = 0;
        for (int i = 1; i < n; ++i) {
            if (numbers[i] - numbers[i - 1] > 1) {
                res.add(resultFormat(numbers[left], numbers[i - 1]));
                left = i;
            }
        }
        if (left < n) {
            res.add(resultFormat(numbers[left], numbers[n - 1]));
        }
        return res;
    }

    private static String resultFormat(int leftNumber, int rightNumber) {
        return leftNumber == rightNumber ? String.valueOf(leftNumber) : String.format("%s -> %s", leftNumber, rightNumber);
    }

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 4, 5, 7, 8};
        List<String> res = getRanges(numbers);
        System.out.println(JSONObject.toJSONString(res));
    }
}
