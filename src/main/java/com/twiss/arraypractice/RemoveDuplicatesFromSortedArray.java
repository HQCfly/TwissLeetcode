package com.twiss.arraypractice;


/**
 * @Author: Twiss
 * @Date: 2021/4/3 11:25 下午
 */
public class RemoveDuplicatesFromSortedArray {

    public static int getResultArray(int[] numbers) {
        int i = 0;
        for (int j = 1; j < numbers.length; ++j) {
            if (numbers[i] != numbers[j]) {
                if (j - i > 1) {
                    numbers[i + 1] = numbers[j];
                }
                i++;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 1, 1, 1, 2, 3, 3, 4};
        int res = getResultArray(numbers);
        System.out.println(res);
    }
}