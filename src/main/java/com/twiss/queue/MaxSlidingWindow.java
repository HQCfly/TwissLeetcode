package com.twiss.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * 单调队列
 *
 * @Author: Twiss
 * @Date: 2022/6/14 9:39 下午
 */
public class MaxSlidingWindow {

    public int[] getMaxValue(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            // peek() -> peekFirst
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                // pollFirst将队列头部元素移除，因为该值不在[i-k+1,i]范围内
                queue.poll();
            }
            // 队列尾部的元素小于nums[i]则推出该值
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            // offerLast
            queue.offer(i);
            if (i >= k - 1) {
                res[idx++] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = new MaxSlidingWindow().getMaxValue(nums, k);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
