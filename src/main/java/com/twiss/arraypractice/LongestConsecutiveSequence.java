package com.twiss.arraypractice;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Twiss
 * @Date: 2021/3/6 8:15 下午
 */
public class LongestConsecutiveSequence {

    public static int longestSequence(int[] arrays){
        Set<Integer> numberSet = new HashSet<Integer>();
        for (int number : arrays){
            numberSet.add(number);
        }
        int longestStreak = 0;
        for (int number : numberSet){
            if (!numberSet.contains(number-1)){
                int currentNumber = number;
                int currentStreak = 1;
                while (numberSet.contains(currentNumber+1)){
                    currentNumber += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        int[] arrays = {100,4,200,1,3,2};
        int res = longestSequence(arrays);
        System.out.println(res);
    }
}
