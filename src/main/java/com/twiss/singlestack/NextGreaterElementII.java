package com.twiss.singlestack;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 下一个更大的元素II
 * @Author: Twiss
 * @Date: 2022/5/25 12:27 下午
 */
public class NextGreaterElementII {

    public int[] getNextGreater(int[] nums1){
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        int size = nums1.length;
        for (int i=0;i<size*2;i++){
            while (!stack.isEmpty()&&nums1[i%size]>nums1[stack.peek()]){
                res[stack.peek()] = nums1[i%size];
                stack.pop();
            }
            stack.push(i%size);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num1 = {1,2,1};
        int[] ans = new NextGreaterElementII().getNextGreater(num1);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
