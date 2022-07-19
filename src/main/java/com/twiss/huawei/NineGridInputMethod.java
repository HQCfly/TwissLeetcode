package com.twiss.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 九宫格
 * @Author: Twiss
 * @Date: 2022/7/19 9:35 下午
 */
public class NineGridInputMethod {

    public String getOutput(String input){
        Map<Character,String> map = new HashMap<>();
        map.put('2',",.");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        map.put('0'," ");
        StringBuilder ans = new StringBuilder();
        int n = input.length();
        boolean isDigit = true;
        int tmpIndex = 0;
        for (int i=0;i<n;i++){
            char c = input.charAt(i);
            if (c=='#'){
                isDigit = !isDigit;
                continue;
            }
            if (c=='/'){
                continue;
            }
            // 输入的是数字
            if (isDigit){
                ans.append(c);
            }else {
                // 输入的是字符串
                String reflect = map.get(c);
                int len = reflect.length();
                // 连续数字
                if (i!=n-1&&input.charAt(i)==input.charAt(i+1)){
                    tmpIndex++;
                    continue;
                }else {
                    ans.append(reflect.charAt(tmpIndex%len));
                    tmpIndex = 0;
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = new NineGridInputMethod().getOutput(input);
        System.out.println(ans);
    }
}
