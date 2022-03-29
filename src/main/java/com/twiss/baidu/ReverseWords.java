package com.twiss.baidu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/3/29 8:43 下午
 */
public class ReverseWords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        Integer len = Integer.valueOf(strings[0]);
        Integer num = Integer.valueOf(strings[1]);
        // 存储输入的字符串
        List<String> samples = new ArrayList<>();
        for (int i=0;i<num;++i){
            samples.add(scanner.nextLine());
        }
        // 使用dfs进行遍历，设置剪枝条件，然后求出最小翻转次数
        Integer max = Integer.MIN_VALUE;
        for(String word:samples){
            dfs(word,new StringBuilder(),max);
        }
    }

    public static void dfs(String word,StringBuilder stringBuilder,Integer max){
        if (stringBuilder.length()==word.length()){
            return;
        }
        // 依次遍历字符串进行递归操作
        // 从长度为1开始到len翻转
    }
}
