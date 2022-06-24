package com.twiss.huawei;

import java.util.Scanner;

/**
 * N进制
 * @Author: Twiss
 * @Date: 2022/6/24 2:20 下午
 */
public class NRadix {

    public String getResult(int radix, String minuend, String subtrahend){
        // 检查进制
        if (radix<2||radix>35){
            return "-1";
        }
        // 检查开头
        if ((minuend.length()!=1&&minuend.startsWith("0"))||
                (subtrahend.length()!=1&&subtrahend.startsWith("0"))){
            return "-1";
        }
        // 检查结尾
        if (subtrahend.endsWith("/0")){
            subtrahend = subtrahend.substring(0,subtrahend.length()-2);
        }
        // 计算，将进制转成10进制进行计算
        int first = 0, second = 0;
        try {
            first = Integer.parseInt(minuend,radix);
            second = Integer.parseInt(subtrahend,radix);
        }catch (Exception e){
            return "-1";
        }
        int res = first-second;
        if (res>0){
            // 转成radix进制结果
            return "0 "+Integer.toString(res, radix);
        }else {
            return "1 "+Integer.toString(res, radix);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] s = sc.nextLine().split(" ");
            int radix = Integer.parseInt(s[0]);
            String minuend = s[1];
            String subtrahend = s[2];
            String ans = new NRadix().getResult(radix,minuend,subtrahend);
            System.out.println(ans);
        }
    }
}
