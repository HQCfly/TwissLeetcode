package com.twiss.baidu;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/3/29 7:52 下午
 */
public class ReverseTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().toString().split(" ");
        if (str==null||str.length<2){
            return;
        }
        Integer num1 = Integer.valueOf(str[0]);
        Integer num2 = Integer.valueOf(str[1]);
        List<Integer> table = new ArrayList<>();

        for (int i=1;i<=num2;++i){
            int res = i*num1;
            String tmp = String.valueOf(res);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j=tmp.length()-1;j>=0;j--){
                stringBuilder.append(tmp.charAt(j));
            }
            Integer reverseRes = Integer.valueOf(stringBuilder.toString());
            table.add(reverseRes);
        }
        table.sort((a,b)->b-a);
        System.out.println(table.get(0));
    }
}
