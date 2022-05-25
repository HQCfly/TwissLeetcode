package com.twiss.singlestack;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 下一个更大的元素I
 * @Author: Twiss
 * @Date: 2022/5/25 12:27 下午
 */
public class NextGreaterElement {

    public int[] getNextGreater(int[] nums1, int[] nums2){
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<nums1.length;i++){
            hashMap.put(nums1[i],i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res,-1);
        for (int i=0;i<nums2.length;i++){
            while (!stack.isEmpty()&&nums2[i]>nums2[stack.peek()]){
                if (hashMap.containsKey(nums2[stack.peek()])){
                    res[hashMap.get(nums2[stack.peek()])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] num1 = {2,4};
        int[] num2 = {1,2,3,4};
        int[] ans = new NextGreaterElement().getNextGreater(num1,num2);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
