package com.twiss.zijie;

import java.util.HashMap;

/**
 * 时间复杂度O(M)
 * 空间复杂度O(M)
 * @Author: Twiss
 * @Date: 2022/4/13 10:29 下午
 */
public class FractionToDecimal {

    public String getDecimal(int numerator, int numerator2){
        long a = numerator, b = numerator2;
        // 如果本身能够整除则进行
        if (a%b==0){
            return String.valueOf(a/b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        // 如果是负数
        if (a * b < 0) stringBuilder.append('-');
        a = Math.abs(a); b = Math.abs(b);
        // 计算小数点前面的
        stringBuilder.append(String.valueOf(a/b)+".");
        HashMap<Long,Integer> map = new HashMap<>();
        a %= b;
        while (a!=0){
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a,stringBuilder.length());
            a *=10;
            stringBuilder.append(a/b);
            a%=b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (map.containsKey(a)){
                int c = map.get(a);
                return String.format("%s(%s)",stringBuilder.substring(0,c),
                        stringBuilder.substring(c));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int num1 = 4, num2 = 333;
        String ans = new FractionToDecimal().getDecimal(num1,num2);
        System.out.println(ans);
    }
}
