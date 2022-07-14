package com.twiss.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 数据分类
 * @Author: Twiss
 * @Date: 2022/7/14 9:40 下午
 */
public class DataClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[12];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
        }
        solution(ints);
    }
    private static void solution(int[] ints) {
        int c = ints[0];
        int b = ints[1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i < ints.length; i++) {
            int r = intByteSum(ints[i]) % b;
            if (r < c) map.put(r, map.containsKey(r) ? map.get(r) + 1 : 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            if (value > max) max = value;
        }
        System.out.println(max);
    }

    private static int intByteSum(int x) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (x >> (i * 8));
        }
        return sum;
    }
}
