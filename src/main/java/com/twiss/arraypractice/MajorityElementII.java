package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Author: Twiss
 * @Date: 2021/3/7 9:57 下午
 */
public class MajorityElementII {
    public static List<Integer> getMajorElementByBoyerMoore(int[] numbers) {
        List<Integer> res = new ArrayList<Integer>();
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int con1 = numbers[0], count1 = 0;
        int con2 = numbers[0], count2 = 0;
        for (int num : numbers) {
            // 投票阶段
            if (con1 == num) {
                count1++;
                continue;
            }
            if (con2 == num) {
                count2++;
                continue;
            }
            // 抵消阶段
            if (count1 == 0) {
                con1 = num;
                count1++;
                continue;
            }
            if (count2 == 0) {
                con2 = num;
                count2++;
                continue;
            }
            count1--;
            count2--;
        }
        count1 = 0;
        count2 = 0;
        for (int num : numbers) {
            if (num == con1) {
                count1++;
            } else if (num == con2) {
                count2++;
            }
        }
        if (count1 > numbers.length / 3) {
            res.add(con1);
        }
        if (count2 > numbers.length / 3) {
            res.add(con2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = {1,1,1,3,3,2,2,2};
        List<Integer> resBoyerMoore = getMajorElementByBoyerMoore(numbers);
        System.out.println("BoyerMoore function: " + JSONObject.toJSONString(resBoyerMoore));
    }
}
