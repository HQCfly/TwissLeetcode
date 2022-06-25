package com.twiss.huawei;

import java.util.*;

/**
 * 最长的指定瑕疵度的元音子串
 * @Author: Twiss
 * @Date: 2022/6/25 9:26 下午
 */
public class MaxVowelSubstring {

    public int getMax(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        Set<String> vowelSet = new HashSet<>();
        vowelSet.add("a");
        List<String> list = Arrays.asList("a","e","i","o","u","A","E","I","O","U");
        for (int i=0;i<s.length();i++){
            if (list.contains(i)){

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();

        }
    }
}
