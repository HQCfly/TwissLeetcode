package com.twiss.huawei;

import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/7/27 7:10 下午
 */
public class StatisticsExpression {

    public static int getConsume(String expression){
        int n = expression.length();
        int times = 0;
        int total = 0;
        for (int i=0;i<n;i++){
            if (total>10){
                return -1;
            }
            if (expression.charAt(i)=='+'){
                total++;
                times++;
            }else if (expression.charAt(i)=='-'){
                total++;
                times++;
            }else if (expression.charAt(i)=='*'){
                total++;
                times = times+2;
            }else if (expression.charAt(i)=='/'){
                total++;
                times = times+4;
            }
        }
        return times;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        int ans = getConsume(expression);
        System.out.println(ans);
    }
}
