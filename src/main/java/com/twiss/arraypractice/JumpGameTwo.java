package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/3/1 10:16 下午
 */
public class JumpGameTwo {

    public static int solved(int[] arrays) {
        int position = arrays.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; ++i) {
                if (i + arrays[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    public static int solved2(int[] arrays) {
        int length = arrays.length;
        int maxPosition = 0;
        int steps = 0;
        int end = 0;
        for (int i = 0; i < length - 1; ++i) {
            maxPosition = Math.max(maxPosition, i + arrays[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arrays = {2, 3, 1, 2, 4, 2, 3};
        int res = solved(arrays);
        System.out.println(res);
        int res2 = solved2(arrays);
        System.out.println(res2);
    }
}
