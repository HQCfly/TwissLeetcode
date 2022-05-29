package com.twiss.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/solution/leetcode-76-zui-xiao-fu-gai-zi-chuan-cja-lmqz/
 * @Author: Twiss
 * @Date: 2022/2/16 11:51 上午
 */
public class MinimumWindowSubstring {

    public String getMinimumWindow(String s, String t) {
        HashMap<Character, Integer> hit = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 将t的所有元素都扔到hit中
        for (int i=0;i<t.length();i++){
            int value = hit.getOrDefault(t.charAt(i),0);
            hit.put(t.charAt(i),value+1);
        }
        String ans = "";
        int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合

        for (int start = 0, end = 0; end < s.length(); end++) {
            char tmp = s.charAt(end);
            int v = window.getOrDefault(s.charAt(end),0);
            window.put(tmp,v+1);
            if (hit.containsKey(tmp)&&window.get(tmp)<=hit.get(tmp)){
                cnt++;
            }
            // start 指针收缩, 更新window的value值
            while (start<end&& (!hit.containsKey(s.charAt(start)))||window.get(s.charAt(start))>hit.get(s.charAt(start))){
                int count = window.get(s.charAt(start))-1;
                window.put(s.charAt(start),count);
                start++;
            }
            // 输出最小包含的子串
            if (cnt==t.length()&&end-start+1<len){
                len = end-start+1;
                ans = s.substring(start,end+1);
            }
        }
        return ans;
    }

    public String getMinimumWindowII(String s, String t){
        Map<Character, Integer> hit = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        // 初始化hit
        for (int i=0;i<t.length();i++){
            Character c = t.charAt(i);
            hit.put(c,hit.getOrDefault(c,0)+1);
        }
        String ans = "";
        // 最小重复子串长度
        int len = Integer.MAX_VALUE;
        // hit包含目标串长度，在s中的
        int cnt = 0;
        for (int start=0,end =0;end<s.length();end++){
            Character c = s.charAt(end);
            // 添加元素到window中
            window.put(c,window.getOrDefault(c,0)+1);
            // 判断并增加cnt
            if (hit.containsKey(c)&&window.get(c)<=hit.get(c)){
                cnt++;
            }
            // 收缩start指针
            while (start<end&&(!hit.containsKey(s.charAt(start)))||(hit.get(s.charAt(start))<window.get(s.charAt(start)))){
                window.put(s.charAt(start),window.get(s.charAt(start))-1);
                start++;
            }
            // 判断最小覆盖子串
            if (cnt==t.length()&&end-start+1<len){
                len = end-start+1;
                ans = s.substring(start,end+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = new MinimumWindowSubstring().getMinimumWindow(s,t);
        System.out.println(ans);
        String s2 = "ADOBECODEBANC";
        String t2 = "ABC";
        String ans2 = new MinimumWindowSubstring().getMinimumWindowII(s2,t2);
        System.out.println(ans2);
    }
}
