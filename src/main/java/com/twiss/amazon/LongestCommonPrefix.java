package com.twiss.amazon;

/**
 * 最长公共前缀
 *
 * @Author: Twiss
 * @Date: 2022/6/6 3:11 下午
 */
public class LongestCommonPrefix {

    public String getCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return null;
        }
        String prefix = strings[0];
        int count = strings.length;
        for (int i = 1; i < count; i++) {
            prefix = commonPrefix(prefix, strings[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String commonPrefix(String s1, String s2) {
        int length = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < length && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }
        return s1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] s = {
                "flower",
                "flow",
                "flight"
        };
        String ans = new LongestCommonPrefix().getCommonPrefix(s);
        System.out.println(ans);
    }
}
