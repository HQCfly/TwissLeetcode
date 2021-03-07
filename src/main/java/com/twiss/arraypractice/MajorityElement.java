package com.twiss.arraypractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/3/7 9:57 下午
 */
public class MajorityElement {

    private static final int DEFAULT_SIZE = 16;

    public static int getMajorElementByHash(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(DEFAULT_SIZE);
        for (int num : numbers) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        assert majorityEntry != null;
        return majorityEntry.getKey();
    }

    public static int getMajorElementBySort(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length / 2];
    }

    public static int getMajorElementByBoyerMoore(int[] numbers) {
        int count = 0;
        int candidate = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (count == 0) {
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] numbers = {7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7};
        int resHash = getMajorElementByHash(numbers);
        System.out.println("Hash function: " + resHash);
        int resSort = getMajorElementBySort(numbers);
        System.out.println("Sort function: " + resSort);
        int resBoyerMoore = getMajorElementByBoyerMoore(numbers);
        System.out.println("BoyerMoore function: " + resBoyerMoore);
    }
}
