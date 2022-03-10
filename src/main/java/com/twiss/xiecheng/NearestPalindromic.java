package com.twiss.xiecheng;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 最近的回文子串
 *
 * @Author: Twiss
 * @Date: 2022/3/10 7:48 下午
 */
public class NearestPalindromic {

    public String getNearest(String data){
        String ans = "";
        boolean condition1 = false, condition2 = false;
        // 循环一次加一年
        for (int i = Integer.parseInt(data); !condition1 || !condition2; i += 10000) {
            String date = Integer.toString(i);
            // 截取年份字符串也就是前半部分，再做反转接在后面形成回文
            StringBuffer sb = new StringBuffer(date.substring(0,4));
            String sb2 = sb.reverse().toString();
            String string = sb.reverse().toString().concat(sb2);
            // 判断回文是否合法
            if (!condition1 && isDate(string) && string.compareTo(data) > 0) {
                ans = string;
                condition1 = true;
            }
            // 加上一个判断是否ABAB型
            if (!condition2 && isDate(string) &&
                    string.compareTo(data) > 0 &&
                    string.substring(0, 2).equals(string.substring(2, 4))&&
                    string.charAt(6) != '0') {
                ans = string;
                condition2 = true;
            }
        }
        return ans;
    }

    // 判断是否合法日期
    public boolean isDate(String date) {
        String dt = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
        // 日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设为false能严格验证日期
            sdf.setLenient(false);
            // 解析生成日期 不合法就抛出异常
            sdf.parse(dt);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "20200202";
        String ans = new NearestPalindromic().getNearest(s);
        System.out.println(ans);
    }

}
