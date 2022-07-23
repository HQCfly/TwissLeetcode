package com.twiss.huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 报文解压
 * @Author: Twiss
 * @Date: 2022/7/23 8:53 下午
 */
public class MessageDecompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        char[] ch = s.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        for (int i=0;i<n;i++){
            if (ch[i]==']'){
                StringBuilder strTmp = new StringBuilder();
                while (!stack.isEmpty()){
                    char pool = stack.pop();
                    if (pool>='a'&&pool<='z'){
                        strTmp.insert(0, String.valueOf(pool));
                    }else if (Character.isDigit(pool)){
                        int num = 0;

                        if (!stack.isEmpty()&&Character.isDigit(stack.peek())){
                            // 两位数数字
                            num = (stack.pop()-'0')*10+(pool-'0');
                            // 三位数字
                            if (num==0){
                                num = (stack.pop()-'0')*100;
                            }
                        }else {
                            num = pool-'0';
                        }
                        String waitStr = strTmp.toString();
                        for (int j=0;j<num;j++){
                            strTmp.append(waitStr);
                        }
                    }
                }
                res.append(strTmp);
            }
            stack.push(ch[i]);
        }
        System.out.println(new String(res));
    }
}
