package com.twiss.weilai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/4/15 8:33 下午
 */
public class CalculateExpression {

    public static List<Integer> getResult(String expression){
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<expression.length();++i){
            Character character = expression.charAt(i);
            // 遍历字符，根据是否是数字和符号进行判断
            if (character=='+'||character=='-'||character=='*'){
                List<Integer> left = getResult(expression.substring(0,i));
                List<Integer> right = getResult(expression.substring(i+1));
                for (int lf:left){
                    for (int rt:right){
                        switch (character){
                            case '+':
                                ans.add(lf+rt);
                                break;
                            case '-':
                                ans.add(lf-rt);
                                break;
                            case '*':
                                ans.add(lf*rt);
                                break;
                        }
                    }
                }
            }
        }
        if (ans.size()==0){
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        List<Integer> ans = getResult(expression);
    }
}
