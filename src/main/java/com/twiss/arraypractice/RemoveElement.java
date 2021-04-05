package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/5 8:10 下午
 */
public class RemoveElement {

    public static int getSubarrayWithoutTarget(int[] numbers,int target){
        int i = 0;
        for (int j = 0; j < numbers.length; ++j) {
            if (target != numbers[j]) {
                numbers[i++] = numbers[j];
            }
        }
        return i;
    }

    public static int getSubarrayWithoutTarget2(int[] numbers,int target){
        int i = 0;
        int n = numbers.length;
        while (i < n) {
            if (numbers[i] == target) {
                numbers[i] = numbers[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] numbers = {0,1,2,2,3,0,4,2};
        int target = 2;
        int res = getSubarrayWithoutTarget(numbers,target);
        System.out.println(res);
        int[] numbers2 = {0,1,2,2,3,0,4,2};
        int target2 = 2;
        int res2 = getSubarrayWithoutTarget2(numbers2,target2);
        System.out.println(res2);
    }
}
