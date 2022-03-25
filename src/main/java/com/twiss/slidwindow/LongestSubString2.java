package com.twiss.slidwindow;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 无重复最长子串
 * map : {"c":index1,"d":index2}
 * start = Math.max(map.get(char),start)
 * ans = Math.max(end-start+1,ans)
 *
 * @Author: Twiss
 * @Date: 2022/3/25 3:00 下午
 */
public class LongestSubString2 {

    public int getLongest(String words) {
        int ans = 0;
        if (words == null || words.length() == 0) {
            return ans;
        }
        int len = words.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int start = 0, end = 0; end < len; ++end) {
            // 如果map中有该字母，说明重复，重置start
            Character character = words.charAt(end);
            if (map.containsKey(character)){
                start = Math.max(map.get(character),start);
            }
            ans = Math.max(ans,end-start+1);
            map.put(character,end+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        // 获取下一行
        // int age = scanner.nextInt();
        int ans = new LongestSubString2().getLongest(words);
        System.out.println(ans);

    }
}
