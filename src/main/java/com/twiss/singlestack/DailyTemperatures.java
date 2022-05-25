package com.twiss.singlestack;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 每日温度
 * @Author: Twiss
 * @Date: 2022/5/25 10:23 上午
 */
public class DailyTemperatures {

    public int[] getDistance(int[] temperature){
        if (temperature==null||temperature.length==0){
            return null;
        }
        int n = temperature.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i=0;i<n;i++){
            // 栈不为空，并且遍历到的元素大于栈顶元素，则进行以下操作
            while (!stack.isEmpty()&&temperature[i]>temperature[stack.peek()]){
                res[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperature = {73, 74, 75, 71, 71, 72, 76, 73};
        int[] ans = new DailyTemperatures().getDistance(temperature);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
