package com.twiss.huawei;

import java.util.Scanner;

/**
 * 比较两个版本
 *
 * @Author: Twiss
 * @Date: 2022/7/4 1:15 下午
 */
public class CompareVersion {

    public int getResult(String v1, String v2) {


        // 去掉连接符
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");

        int len1 = arr1.length;
        int len2 = arr2.length;


        // 两两比较
        for (int i = 0; i < len1 && i < len2; i++) {
            int res = helper(arr1[i], arr2[i]);
            if (res != 0) {
                return res;
            }
        }

        // arr1 长
        if (len1 > len2) {
            int k = len2;
            while (k < len1) {
                int res = helper(arr1[k], "");
                if (res != 0) {
                    return res;
                }
                k++;
            }
            return 0;
        }

        // arr2 长
        if (len2 > len1) {
            int k = len1;
            while (k < len2) {
                int res = helper("", arr2[k]);
                if (res != 0) {
                    return res;
                }
                k++;
            }
            return 0;
        }

        return 0;
    }

    // 比较两个字版本号的大小
    public static int helper(String v1, String v2) {
        // 1. 先删除子版本号前面的0
        StringBuilder sb1 = new StringBuilder(v1);
        while (sb1.length() > 0 && sb1.charAt(0) == '0') {
            sb1.deleteCharAt(0);
        }

        StringBuilder sb2 = new StringBuilder(v2);
        while (sb2.length() > 0 && sb2.charAt(0) == '0') {
            sb2.deleteCharAt(0);
        }

        // 2. 逐个字符比较
        for (int i = 0; i < sb1.length() && i < sb2.length(); i++) {
            if (sb1.charAt(i) > sb2.charAt(i)) return 1;
            else if (sb1.charAt(i) < sb2.charAt(i)) return -1;
        }

        // 3. sb1 更长
        int len1 = sb1.length();
        int len2 = sb2.length();
        if (len1 > len2) {
            int k = len2;
            while (k < len1) {
                if (sb1.charAt(k) > '0') return 1;
                k++;
            }
            return 0;
        }

        // sb2 更长
        if (len2 > len1) {
            int k = len1;
            while (k < len2) {
                if (sb2.charAt(k) > '0') return -1;
                k++;
            }
            return 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs1 = sc.nextLine();
        String strs2 = sc.nextLine();
        int ans = new CompareVersion().getResult(strs1, strs2);
        System.out.println(ans);
    }
}
