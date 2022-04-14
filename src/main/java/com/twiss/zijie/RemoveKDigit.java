package com.twiss.zijie;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移除k位数字使其后续数字最小
 * 单调栈
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 *
 * @Author: Twiss
 * @Date: 2022/4/14 9:25 下午
 */
public class RemoveKDigit {

    public String getMin(String nums,int k) {
        if (nums == null || nums.length() == 0) {
            return "0";
        }
        int n = nums.length();
        StringBuilder stringBuilder = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<n;++i){
            Character tmp = nums.charAt(i);
            while (k>0&&!stack.isEmpty()&&tmp<stack.peek()){
                stack.pop();
                k--;
            }
            if (tmp!='0'||!stack.isEmpty()){
                stack.push(tmp);
            }
        }

        // 如果还没删够，要从stack继续删，直到k=0
        while (k>0&&!stack.isEmpty()){
            stack.pop();
            k--;
        }

        while (!stack.isEmpty()){
            stringBuilder.append(stack.pollLast());
        }

        return stringBuilder.length()==0?"0":stringBuilder.toString();

    }

    public static void main(String[] args) {
        String nums = "1432219";
        int k = 3;
        String ans = new RemoveKDigit().getMin(nums,k);
        System.out.println(ans);
    }
}
