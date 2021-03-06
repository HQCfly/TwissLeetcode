package com.twiss.arraypractice;

import java.util.Stack;

/**
 * @Author: Twiss
 * @Date: 2021/3/3 9:24 下午
 */
public class LargestRectangleArea {

    public static int maxArea(int[] array){
        int n = array.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> tempStack = new Stack<Integer>();

        for (int i = 0 ; i < n; ++i){
            while ((!tempStack.empty())&&(array[tempStack.peek()]>=array[i])){
                tempStack.pop();
            }
            left[i] = tempStack.empty() ? -1: tempStack.peek();
            tempStack.push(i);
        }
        tempStack.clear();
        for (int i = n-1 ; i > 0; i--){
            while ((!tempStack.empty())&&(array[tempStack.peek()]>=array[i])){
                tempStack.pop();
            }
            right[i] = tempStack.empty() ? n: tempStack.peek();
            tempStack.push(i);
        }
        int area = 0;
        for (int i = 0; i<n;++i){
            area = Math.max(area,(right[i]-left[i]-1)*array[i]);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] array = {2,1,5,6,2,3};
        int area = maxArea(array);
        System.out.println(area);
    }
}
