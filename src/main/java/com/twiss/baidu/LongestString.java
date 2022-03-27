package com.twiss.baidu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 最长字符串
 * 前缀和+二分法
 *
 * @Author: Twiss
 * @Date: 2022/3/27 10:15 下午
 */
public class LongestString {

    private int l1, r1, l2, r2;

    public void getString(String words) {
        int len = words.length();
        // 前缀和
        int[] prefix = new int[len];
        for (int i = 0, num = 0; i < len; ++i) {
            num += words.charAt(i) - '0';
            prefix[i] = num;
        }

        int l = 2, r = len - 1;
        l1 = r1 = l2 = r2 = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (check(prefix, len, m)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println("S1: " + words.substring(l1, r1));
        System.out.println("S2: " + words.substring(l2, r2));
        l1 = l1 + 1;
        r1 = r1 + 1;
        l2 = l2 + 1;
        r2 = r2 + 1;
        System.out.println("index: l1:" + l1 + " r1:" + r1 + " l2:" + l2 + " r2:" + r2);
    }

    private boolean check(int[] prefix, int len,
                          int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        boolean valid = false;
        for (int i = 0; i <= len - m; ++i) {
            int one;
            if (i == 0) {
                one = prefix[i + m - 1];
            } else {
                one = prefix[i + m - 1] - prefix[i - 1];
            }
            if (!hashSet.contains(one)) {
                hashSet.add(one);
                map.put(one, i);
            } else {
                // 此时表明S1和S2中的1和0的数量是一样的
                l1 = map.get(one);
                r1 = l1 + m - 1;
                l2 = i;
                r2 = l2 + m - 1;
                valid = true;
                break;
            }
        }
        return valid;
    }

    /**
     * 10011
     * output:
     *  S1: 001
     *  S2: 011
     *  l1:1 r1:4 l2:2 r2:5
     * @param args
     */
    public static void main(String[] args) {
        String words = "10011";
        new LongestString().getString(words);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int begin = 0, end = s.length() - 1;
        int[] longSubLeft;
        int[] longSubRight;
        while (s.charAt(begin) != s.charAt(end)) begin++;
        longSubLeft = new int[]{begin, end - 1, begin + 1, end};
        begin = 0;
        end = s.length() - 1;
        while (s.charAt(begin) != s.charAt(end)) end--;
        longSubRight = new int[]{begin, end - 1, begin + 1, end};
        int[] ret = longSubLeft[1] - longSubLeft[0] >= longSubRight[1] - longSubRight[0] ? longSubLeft : longSubRight;
        for (int i = 0; i < 4; i++) ret[i]++;
        System.out.print(ret[0] + " " + ret[1] + " " + ret[2] + " " + ret[3]);

    }
}
