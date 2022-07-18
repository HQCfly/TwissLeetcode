package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 仿LISP计算
 * @Author: Twiss
 * @Date: 2022/7/17 10:11 下午
 */
public class MockLisp {

    public int getResult(String operation){
        // 存放计算结果
        Deque<Integer> dataStack = new LinkedList<>();
        // 存放操作符
        Deque<String> opStack = new LinkedList<>();
        try {
            for (int i=0;i<operation.length();){
                char c = operation.charAt(i);
                if (c==' '){
                    i++;
                    continue;
                }
                if (c=='('){
                    // 操作符入栈
                    opStack.push(operation.substring(i+1,i+4));
                    i = i+4;
                    continue;
                }
                if (c=='-'){
                    i++;
                    continue;
                }
                // 如果是数字，连续读取，并压入栈
                if (Character.isDigit(c)){
                    int j = i;
                    while (Character.isDigit(j+1)){
                        j++;
                    }
                    dataStack.push(
                            Integer.parseInt(operation.substring(i,j+1))
                    );
                    i = j+1;
                    continue;
                }
                if (c==')'){
                    String op = opStack.pop();
                    Integer p2 = dataStack.pop();
                    Integer p1 = dataStack.pop();
                    Integer res = calculate(op,p2,p1);
                    dataStack.push(res);
                    i++;
                }
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
        if (opStack.isEmpty()){
            return dataStack.pop();
        }else {
            throw new RuntimeException();
        }
    }

    private int calculate(String op, Integer p2, Integer p1){
        switch (op){
            case "add":
                return p1+p2;
            case "sub":
                return p1-p2;
            case "mul":
                return p1*p2;
            case "div":
                return p1/p2;
            default:
                throw new RuntimeException();
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();
        try {
            int ans = new MockLisp().getResult(op);
            System.out.println(ans);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
