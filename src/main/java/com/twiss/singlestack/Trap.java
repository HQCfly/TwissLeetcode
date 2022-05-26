package com.twiss.singlestack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: Twiss
 * @Date: 2022/5/26 2:11 下午
 */
public class Trap {

    public int getTrapByDouble(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i==0 || i== height.length - 1) continue;

            int rHeight = height[i]; // 记录右边柱子的最高高度
            int lHeight = height[i]; // 记录左边柱子的最高高度
            for (int r = i+1; r < height.length; r++) {
                if (height[r] > rHeight) rHeight = height[r];
            }
            for (int l = i-1; l >= 0; l--) {
                if(height[l] > lHeight) lHeight = height[l];
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) sum += h;
        }
        return sum;
    }

    public int getTrapByStack(int[] height){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int sum = 0;
        for (int i=1;i<height.length;i++){
            int stackTop = stack.peek();
            if (height[i]<height[stackTop]){
                stack.push(i);
            }else if (height[i]==height[stackTop]){
                stack.pop();
                stack.push(i);
            }else {
                int heightAtIdx = height[i];
                while (!stack.isEmpty()&&(heightAtIdx>height[stackTop])){
                    int mid = stack.pop();
                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.min(height[left],height[i])-height[mid];
                        int w = i-left-1;
                        int hold = h*w;
                        if (hold>0){
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = new Trap().getTrapByDouble(height);
        System.out.println(ans);
        int ans2 = new Trap().getTrapByStack(height);
        System.out.println(ans2);
    }
}
