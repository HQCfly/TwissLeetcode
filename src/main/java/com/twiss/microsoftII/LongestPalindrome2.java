package com.twiss.microsoftII;

/**
 * 最长回文子串
 * @Author: Twiss
 * @Date: 2022/3/17 3:41 下午
 */
public class LongestPalindrome2 {

    public String getLongestPalindrome(String words){
        int len = words.length();
        if (len<2){
            return words;
        }
        boolean[][] dp = new boolean[len][len];
        for (int i=0;i<len;++i){
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;

        for(int L=2;L<len;L++){
            for (int i=0;i<len;++i){
                int j = L+i-1;
                // 边界问题
                if (j>=len){
                    break;
                }
                // 判断是否是回文
                if (words.charAt(i)!=words.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 更新maxLen和begin位置
                if (dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return words.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String words = "abaa";
        String ans = new LongestPalindrome2().getLongestPalindrome(words);
        System.out.println(ans);
    }
}
