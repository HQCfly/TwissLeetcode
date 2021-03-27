package com.twiss.arraypractice;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/3/27 6:48 下午
 */
public class MissingNumber {

    public static int getMissingNumberInSort(int[] numbers) {
        Arrays.sort(numbers);
        if (numbers[numbers.length - 1] != numbers.length) {
            return numbers.length;
        } else if (numbers[0] != 0) {
            return 0;
        }
        for (int i = 1; i < numbers.length; ++i) {
            int expectNumber = numbers[i - 1] + 1;
            if (numbers[i] != expectNumber) {
                return expectNumber;
            }
        }
        return -1;
    }

    public static int getMissingNumberInHash(int[] numbers) {
        Set<Integer> nums = new HashSet<>();
        for (int num : numbers) {
            nums.add(num);
        }
        for (int i = 0; i <= numbers.length; ++i) {
            if (!nums.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int getMissingNumberInXOR(int[] numbers) {
        int missing = numbers.length;
        for (int i = 0; i < numbers.length; ++i) {
            missing ^= i ^ numbers[i];
        }
        return missing;
    }

    public static int getMissingNumberInMath(int[] numbers) {
        int n = numbers.length;
        int sum = 0;
        for (int i = 0; i < numbers.length; ++i) {
            sum+=numbers[i];
        }
        return n*(n+1)/2-sum;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 0, 1};
        int res = getMissingNumberInSort(numbers);
        System.out.println(res);
        int res2 = getMissingNumberInHash(numbers);
        System.out.println(res2);
        int res3 = getMissingNumberInXOR(numbers);
        System.out.println(res3);
        int res4 = getMissingNumberInMath(numbers);
        System.out.println(res4);
    }
}
