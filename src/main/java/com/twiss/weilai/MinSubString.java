package com.twiss.weilai;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Twiss
 * @Date: 2022/4/15 8:06 下午
 */
public class MinSubString {

    public static String getSubString(String s1,String s2){
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for (int i=0;i<s2.length();++i){
            map2.put(s2.charAt(i),map2.getOrDefault(s2.charAt(i),0)+1);
        }
        int left = 0;
        int right = 0;
        int minLen = s1.length();
        int markLeft = -1;
        int markRight = -1;

        while (right<s1.length()){
            // 向右边滑动
            if (map2.containsKey(s1.charAt(right))){
                map1.put(s1.charAt(right),map1.getOrDefault(s1.charAt(right),0)+1);
            }
            right++;

            // 向左滑动
            while (valid(map1,map2)){
                if (right-left<=minLen){
                    minLen = right-left;
                    markLeft = left;
                    markRight = right;
                }
                if (map2.containsKey(s1.charAt(left))){
                    map1.put(s1.charAt(left),map1.getOrDefault(s1.charAt(left),0)-1);
                }
                left++;
            }
        }
        return markLeft == -1?"":s1.substring(markLeft,markRight);
    }

    private static boolean valid(HashMap<Character,Integer> map1,
                          HashMap<Character,Integer> map2){
        for (Character ch:map2.keySet()){
            if (map2.get(ch)>map1.getOrDefault(ch,0)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String ans = getSubString(s1,s2);
        System.out.println(ans);
    }
}
