package com.twiss.slidwindow;

import com.alibaba.fastjson.JSONObject;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 * intpu: [1,3,-1,-3,5,3,6,7] k = 3
 * output: [3,3,5,5,6,7]
 * 方法一：最大堆
 * 方法二：单调栈
 *
 * @Author: Twiss
 * @Date: 2022/2/17 4:33 下午
 */
public class SlidingWindowMaximum {

    public int[] getMaxSlidingWindowByMaxHeap(int[] nums, int k) {
        int n = nums.length;
        // 最大堆
        PriorityQueue<int[]> priorityQueue =
                new PriorityQueue<int[]>(new Comparator<int[]>() {

                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
                    }
                });

        // 将前k个元素添加到优先队列中
        for (int i = 0; i < k; ++i) {
            priorityQueue.add(new int[]{nums[i], i});
        }
        // 针对前k个元素选择最大的元素
        int[] ans = new int[n - k + 1];
        ans[0] = priorityQueue.peek()[0];
        for (int i = k; i < n; ++i) {
            priorityQueue.offer(new int[]{nums[i], i});
            // 堆中的最大元素下标如果小于当前i-k表示滑动窗口已经往后移动了
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            ans[i - k + 1] = priorityQueue.peek()[0];
        }
        return ans;
    }

    public int[] getMaxSlidingWindowBySingleStack(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        // 将前k个元素组成一个单调栈
        for (int i = 0; i < k; ++i) {
            // last是栈顶元素
            while (!stack.isEmpty()&&nums[i]>=nums[stack.peekLast()]){
                stack.pollLast();
            }
            stack.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        // 栈低是最大的元素
        ans[0] = nums[stack.peekFirst()];
        for (int i=k;i<n;++i){
            while (!stack.isEmpty()&&nums[i]>=nums[stack.peekLast()]){
                stack.pollLast();
            }
            stack.offerLast(i);
            // 当最大元素下标已经小于当前滑动窗口最小值，则删除
            while (stack.peekFirst()<=i-k){
                stack.pollFirst();
            }
            ans[i-k+1] = nums[stack.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new SlidingWindowMaximum().getMaxSlidingWindowByMaxHeap(nums,k);
        System.out.println(JSONObject.toJSONString(res));

        int[] res2 = new SlidingWindowMaximum().getMaxSlidingWindowBySingleStack(nums,k);
        System.out.println(JSONObject.toJSONString(res2));

    }
}
