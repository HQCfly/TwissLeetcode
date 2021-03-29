package com.twiss.arraypractice;

import com.alibaba.fastjson.JSONObject;

public class NextPermutation {

    public static int[] getNextPermutation(int[] numbers){
        int n = numbers.length;
        int i=n-2;
        while (i>=0&&numbers[i]>=numbers[i+1]){
            i--;
        }
        if (i>=0){
            int j = numbers.length-1;
            while (j>=0&&numbers[i]>=numbers[j]){
                j--;
            }
            swap(numbers,i,j);
        }
        return numbers;
    }

    public static void swap(int[] numbers, int i, int j){
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    public static void main(String[] args) {
        int[] numbers = {4,5,3,6,2,1};
        int[] res = getNextPermutation(numbers);
        System.out.println(JSONObject.toJSONString(res));
    }
}
