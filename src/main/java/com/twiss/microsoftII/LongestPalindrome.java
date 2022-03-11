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
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return words.substring(begin, begin + maxLen);
    }

    public String getPalindromeByCenter(String words) {
        if (words.length() <= 2) {
            return words;
        }
        int start = 0, end = 0;
        int len = words.length();
        for (int i = 0; i < len; ++i) {
            // 分别获取以当前i为中心点向两边扩散的是回文的长度
            int lenOdd = expandCenter(words, i, i);
            int lenEven = expandCenter(words, i, i + 1);
            // 对比较大的长度
            int subLen = Math.max(lenOdd, lenEven);
            if (subLen >end-start){
                // 以i为中心向两边扩散
                start = i-(subLen-1)/2;
                end = i+len/2;
            }
        }
        return words.substring(start,end+1);
    }

    /**
     * 有中心点向两边扩散
     *
     * @param words
     * @param left
     * @param right
     * @return
     */
    private int expandCenter(String words, int left, int right) {
        // left==right的时候说明此时的回文字符串是一个字符，回文串长度为奇数
        // left!=right说明是偶数，中心是空隙
        while (left>=0&&right<words.length()&&words.charAt(left)==words.charAt(right)){
            left--;
            right++;
        }
        // 回文子串的长度是right-left+1-2
        return right-left-1;
    }

    public static void main(String[] args) {
        String word = "abacdse";
        String ans = new LongestPalindrome().getPalindrome(word);
        System.out.println(ans);

        String word2 = "abacdse";
        String ans2 = new LongestPalindrome().getPalindromeByCenter(word2);
        System.out.println(ans2);
    }
}
