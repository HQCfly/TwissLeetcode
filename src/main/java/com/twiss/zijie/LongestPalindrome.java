package com.twiss.zijie;

/**
 * 最长回文子串
 * 动态规划从左到右
 * 从中间到两边
 * 时间复杂度O(N^2)
 * 空间复杂度O(N^2)
 * @Author: Twiss
 * @Date: 2022/4/25 7:34 下午
 */
public class LongestPalindrome {

    public String getLongestSubString(String words){
        if (words.length()<=2){
            return words;
        }
        int n = words.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0;i<n;++i){
            dp[i][i] = true;
        }
        int start = 0;
        int maxLen = 1;
        for (int L=1;L<n;++L){
            for (int i=0;i<n;++i){
                int j = L+i-1;
                if (j>=n){
                    break;
                }
                if (words.charAt(i)!=words.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    start = i;
                }
            }
        }
        return words.substring(start,maxLen+start);
    }

    public String getSubStringByExpend(String words){
        if (words.length()<=2){
            return words;
        }
        int start = 0, end = 0;
        int len = words.length();
        for (int i=0;i<len;++i){
            int oddLen = expendCenter(words,i,i);
            int evenLen = expendCenter(words,i,i+1);
            int sunLen = Math.max(oddLen,evenLen);
            if (sunLen>end-start){
                start = i-(sunLen-1)/2;
                end = i+sunLen/2;
            }
        }
        return words.substring(start,end+1);

    }

    private int expendCenter(String words, int left, int right){
        while (left>=0&&right<words.length()&&words.charAt(left)==words.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String word = "abacdse";
        String ans = new LongestPalindrome().getLongestSubString(word);
        System.out.println(ans);

        String ans2 = new LongestPalindrome().getSubStringByExpend(word);
        System.out.println(ans2);
    }
}
