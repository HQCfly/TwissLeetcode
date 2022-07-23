package com.twiss.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 文本统计
 *
 * @Author: Twiss
 * @Date: 2022/7/23 9:22 下午
 */
public class MessageStatistics {

    /**
     * input: a:3,b:5,c:2@a:1,b:2
     * output: a:2,b:3,c:2
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split("@");
        String[] allStr = str[0].split(",");   // 全量字符集
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Character> list = new ArrayList<>();
        // 统计全量字符集中各个字符的数量
        for (int i = 0; i < allStr.length; i++) {
            String[] aStr = allStr[i].split(":");
            char ch1 = aStr[0].charAt(0);   // astr[0]是字符
            int n1 = Integer.parseInt(aStr[1]);  // astr[1]是数字
            map.put(ch1, n1);
            list.add(ch1);
        }
        if (str.length > 1) {  // 说明有占用字符集
            String[] yongStr = str[1].split(",");
            // 在全量字符集上减去对应的占用字符集
            for (int i = 0; i < yongStr.length; i++) {
                String[] yStr = yongStr[i].split(":");
                char ch2 = yStr[0].charAt(0);
                int n2 = Integer.parseInt(yStr[1]);
                map.put(ch2, map.get(ch2) - n2);
            }
        } else { // 说明无占用字符集a:3,b:5,c:2@
            String res = str[0] + "@";
            System.out.println(res);
            return;
        }
        ArrayList<String> list2 = new ArrayList<>();  // 存储最后的String结果
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            String x = "";
            if (map.get(c) > 0) {
                x = c + ":" + map.get(c);
                list2.add(x);
            }
        }
        // 输出格式
        if (list2.size() > 0) {
            for (int i = 0; i < list2.size() - 1; i++) {
                System.out.print(list2.get(i) + ",");
            }
            System.out.print(list2.get(list2.size() - 1));
        }
    }
}
