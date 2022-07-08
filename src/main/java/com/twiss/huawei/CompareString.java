package com.twiss.huawei;

import java.util.Scanner;

/**
 * 字符串比较
 *
 * @Author: Twiss
 * @Date: 2022/6/22 1:15 下午
 */
public class CompareString {

    public int getLength(String A, String B, int V) {
        char[] Aarr = A.toCharArray();
        char[] Barr = B.toCharArray();
        int sum = 0, len = 0;
        for (int i = 0; i < Aarr.length; i++) {
            sum += Math.abs(Aarr[i] - Barr[i]);
            if (sum <= V) {
                len++;
            } else {
                sum = 0;
                if (len > 0) {
                    break;
                }
            }
        }
        System.out.println(len);
        return len;
    }

    public int getLength2(String A, String B, int v) {
        char[] As = A.toCharArray();
        char[] Bs = B.toCharArray();
        int first = 0;
        int len = 0;
        int cha = 0;
        for (int i = 0; i < As.length - 1; i++) {
            int tempLast = 0;
            if (As[i + 1] == As[i] + 1) {
                tempLast = i + 1;
            } else {
                first = i + 1;
                continue;
            }

            for (int j = first; j <= tempLast - 1; j++) {
                if (Bs[j + 1] != Bs[j] + 1) {
                    cha = 0;
                    break;
                }

                if (j == first) {
                    cha += Math.abs(As[j] - Bs[j]);
                }
                cha += Math.abs(As[j + 1] - Bs[j + 1]);
            }

            int tempLen = tempLast - first + 1;
            if (cha <= v && tempLen > len) {
                len = tempLen;
                cha = 0;
            }
        }

        System.out.println(len);
        return len;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        int V = sc.nextInt();
        int len1 = new CompareString().getLength(A, B, V);
        System.out.println("len1:" + len1);
        int len2 = new CompareString().getLength2(A, B, V);
        System.out.println("len2:" + len2);
    }
}
