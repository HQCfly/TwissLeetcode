package com.twiss.zijie;

import java.util.HashMap;
import java.util.Map;

/**
 * 分数到小数
 * @Author: Twiss
 * @Date: 2022/4/17 7:18 下午
 */
public class FractionToDecimal2 {

    public String getNum(int num1,int num2){
        long a = num1;
        long b = num2;
        String ans = "";
        Map<Long,Integer> map = new HashMap<>();
        // 能整除的情况
        if (a%b==0){
            return ans = String.valueOf(a/b);
        }
        // 不能整除的话
        StringBuilder stringBuilder = new StringBuilder();
        // 如果是负数
        if (a*b<0){
            stringBuilder.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        // 小数点之前的先计算出来
        stringBuilder.append((a/b)+".");
        a %=b;
        while (a!=0){
            map.put(a,stringBuilder.length());
            a*=10;
            stringBuilder.append(a/b);
            a%=b;
            if (map.containsKey(a)){
                int c = map.get(a);
                return String.format("%s(%s)",stringBuilder.substring(0,c),stringBuilder.substring(c));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int a = 4, b =333;
        String ans = new FractionToDecimal2().getNum(a,b);
        System.out.println(ans);
    }
}
