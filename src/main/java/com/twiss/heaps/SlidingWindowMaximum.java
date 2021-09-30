package com.twiss.heaps;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Twiss
 * @Date: 2021/9/30 10:23 上午
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums,int k){
        int n = nums.length;
        // 设置一个比较器，当两者相同的时候，比较下标的位置，下标大的在前面
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1,p2)->p1[0]!=p2[0]?p2[0]-p1[0]:p2[1]-p1[1]);
        // 初始化前k个元素到堆中
        for (int i=0;i<k;++i){
            queue.offer(new int[]{nums[i],i});
        }
        // 有n-k+1个元素
        int[] ans = new int[n-k+1];
        // 将第一次的答案加入ans中
        ans[0] = queue.peek()[0];
        for (int i=k;i<n;++i){
            // 新元素加入最大堆中
            queue.offer(new int[]{nums[i],i});
            // 循环判断当前队首是否在窗口，窗口左边界是i-k，把不在滑动窗口的最大元素出队列
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            // 在窗口直接辅值
            ans[i-k+1] = queue.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindowBySingleStack(int[] nums,int k){
        int n = nums.length;
        // 创建双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        // 初始化前k个元素
        for (int i=0;i<k;++i){
            // 判断队列是否为空或者当前num大于队尾元素，大于则出队
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            // 当前元素入队
            // 由于需要判断当前元素是否在窗口，所以实际上存储的事元素下标
            // 根据下标寻找元素比根据元素寻找下标方便
            deque.offerLast(i);
        }
        int[] ans = new int[n-k+1];
        // 添加当前最大元素
        ans[0] = nums[deque.peekFirst()];
        for (int i=k;i<n;i++){
            // 判断队列是否为空或者当前num大于队尾元素，大于则出队
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            // 当前元素入队
            deque.offerLast(i);
            // 循环判断当前队首是否在窗口，窗口左边界是i-k，把不在滑动窗口的最大元素出队列
            while (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            // 添加答案
            ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums,k);
        System.out.println(JSONObject.toJSONString(res));

        int[] res2 = new SlidingWindowMaximum().maxSlidingWindowBySingleStack(nums,k);
        System.out.println(JSONObject.toJSONString(res2));
    }
}
