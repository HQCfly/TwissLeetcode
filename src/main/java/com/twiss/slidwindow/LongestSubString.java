package com.twiss.slidwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * start = Max(map(key),start)
 * ans = Max(end-start+1,ans)
 *
 * @Author: Twiss
 * @Date: 2022/2/15 12:25 下午
 */
public class LongestSubString {

    public int getLongestSubString(String words) {
        int n = words.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int start = 0, end = 0; end < n; end++) {
            Character character = words.charAt(end);
            if (map.containsKey(character)) {
                start = Math.max(map.get(character), start);
            }
            ans = Math.max(end - start + 1, ans);
            map.put(character, end + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String words = "abcabcbb";
        int res = new LongestSubString().getLongestSubString(words);
        System.out.println(res);

        String words1 = "bbbbb";
        int res1 = new LongestSubString().getLongestSubString(words1);
        System.out.println(res1);
    }
}
