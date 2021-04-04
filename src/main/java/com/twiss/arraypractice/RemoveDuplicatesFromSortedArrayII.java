package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/4/4 7:16 下午
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int getResultArray(int[] numbers) {
        int i = 2;
        for (int j = 2; j < numbers.length; ++j) {
            if (numbers[i - 2] != numbers[j]) {
                numbers[i++] = numbers[j];
            }
        }
        return i;
    }

    public static int getResultArray2(int[] numbers) {
        int i = 1, count = 1;
        for (int j = 1; j < numbers.length; ++j) {
            if (numbers[j-1]==numbers[j]){
                count++;
            } else {
                count = 1;
            }
            if (count<=2){
                numbers[i++] = numbers[j];
            }
        }
        return i-1;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 1, 1, 1, 2, 3, 3, 4};
//        int[] numbers = {1, 1, 1, 2, 2, 3};
        int res = getResultArray(numbers);
        System.out.println(res);
        int res2 = getResultArray2(numbers);
        System.out.println(res2);
    }
}
