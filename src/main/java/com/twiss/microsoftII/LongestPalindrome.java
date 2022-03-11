package com.twiss.microsoftII;

/**
 * 回文子串
 * 时间复杂度O(N^2)
 * 空间复杂度O(N^2)
 *
 * @Author: Twiss
 * @Date: 2022/3/11 6:45 下午
 */
public class LongestPalindrome {

    public String getPalindrome(String words) {
        if (words.length() <= 2) {
            return words;
        }
        int len = words.length();
        boolean[][] dp = new boolean[len][len];
        // 将长度为1的都设置为true
        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        for (int L = 2; L < len; ++L) {
            for (int i = 0; i < len; ++i) {
                int j = i + L - 1;
                if (j >= len) {
                    break;
                }
                if (words.charAt(i) != words.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return words.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String word = "abacdse";
        String ans = new LongestPalindrome().getPalindrome(word);
        System.out.println(ans);
    }
}
