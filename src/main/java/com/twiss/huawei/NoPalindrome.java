package com.twiss.huawei;

import java.util.Scanner;

/**
 * 非回文子串
 *
 * @Author: Twiss
 * @Date: 2022/6/29 10:08 下午
 */
public class NoPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            p = 'a' + p - 1;
            int i, j;
            for (i = n - 1; i >= 0; i--) {
                for (j = arr[i] + 1; j <= p; j++) {
                    // 过滤条件，判断是否是回文
                    if (i >= 1 && j == arr[i - 1] || i >= 2 && j == arr[i - 2]) {
                        continue;
                    }
                    break;
                }
                if (j <= p) {
                    arr[i] = (char) j;
                    break;
                }
            }
            if (i == -1) {
                System.out.println("NO");
            } else {
                for (int k = i + 1; k < n; k++) {
                    for (j = 'a'; j <= p; j++) {
                        // 过滤回文
                        if (k >= 1 && j == arr[k - 1] || k >= 2 && j == arr[i - 2]) {
                            continue;
                        }
                        arr[k] = (char) j;
                        break;
                    }
                }
                System.out.println(new String(arr));
            }
        }

    }
}
