package com.twiss.backtracking;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/5/22 7:31 下午
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 深度遍历
     * a          b
     * d e f      d e f
     *
     * @param digits
     * @return
     */
    private List<String> getResult(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrace(0, new StringBuilder(), digits, phoneMap, res);
        return res;
    }

    private void backtrace(int index, StringBuilder combination,
                           String digits, Map<Character, String> phoneMap,
                           List<String> res) {
        if (index == digits.length()) {
            res.add(combination.toString());
            return;
        }
        // 一个一个的获取数字
        char digit = digits.charAt(index);
        // 获取数字对应的映射
        String letters = phoneMap.get(digit);
        int countLetter = letters.length();
        // 遍历数字映射
        for (int i = 0; i < countLetter; i++) {
            // 添加第i个字母到combination中
            combination.append(letters.charAt(i));
            backtrace(index + 1, combination, digits, phoneMap, res);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        String digits = "234";
        List<String> res = new LetterCombinationsOfAPhoneNumber().getResult(digits);
        System.out.println(JSONObject.toJSONString(res));
    }
}
