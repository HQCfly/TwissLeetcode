package com.twiss.dahua;

import java.util.Scanner;

/**
 * 截取字符串
 * https://blog.csdn.net/weixin_42565135/article/details/102819388
 * @Author: Twiss
 * @Date: 2022/6/25 10:20 上午
 */
public class SplitString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String str1 = scan.next();
            int n = scan.nextInt();
            str_split(str1, n);
        }
    }

    public static void str_split(String str1, int n) {
        if (str1 == null) {
            System.out.println("please input valid!");
            return;
        }
        int byte_all = 0;
        byte_all = str1.length();
        byte byte_[] = str1.getBytes();
        if (n > byte_all)
            n = byte_all;
        if (byte_[n - 1] < 0) {

            System.out.println("subStrx==" + new String(byte_,0, n-1));
        } else {
            System.out.println("subStrx==" + new String(byte_,0, n));
        }
    }
}
