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

    public String getLongestPalindromeByWindow(String words){
        int n = words.length();
        if (n<= 2) {
            return words;
        }
        int start = 0, end = 0;
        for (int i=0;i<n;++i){
            // 以i为中心的向i两边扩展
            int lenOdd = expendCenter(words,i,i);
            // 以空为中心的向i两边扩展
            int lenEven = expendCenter(words,i,i+1);
            int subLen = Math.max(lenOdd,lenEven);
            if (subLen>end-start){
                // 以i为中心向两边扩展
                start = i-(subLen-1)/2;
                end = i+subLen/2;
            }
        }
        return words.substring(start,end+1);
    }

    private int expendCenter(String words, int left, int right){
        while (0<=left&&right<=words.length()-1&&words.charAt(left)==words.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String words = "abaa";
        String ans = new LongestPalindrome2().getLongestPalindrome(words);
        System.out.println(ans);

        String words2 = "abaa";
        String ans2 = new LongestPalindrome2().getLongestPalindromeByWindow(words2);
        System.out.println(ans2);
    }
}
