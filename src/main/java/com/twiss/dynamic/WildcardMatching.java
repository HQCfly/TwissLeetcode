package com.twiss.dynamic;

/**
 * @Author: Twiss
 * @Date: 2021/6/17 11:23 下午
 */
public class WildcardMatching {

    private boolean isMatch(String words, String pattern) {
        if (pattern == null) {
            return words == null;
        }

        // 字符串是空，并且模式串只有一个匹配规则
        if (words == null && pattern.length() == 1) {
            return false;
        }

        int wLength = words.length();
        int pLength = pattern.length();
        boolean dp[][] = new boolean[wLength][pLength];

        dp[0][0] = true;
        // 先检查模式串是否有*，如果有则d[0][j]=dp[0][j-2]
        for (int j = 2; j < pLength; j++) {
            if (pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 整体遍历模式串和字符串
        for (int r = 1; r < wLength; r++) {
            int i = r - 1;
            for (int c = 1; c < pLength; c++) {
                int j = c - 1;
                if (words.charAt(i)==pattern.charAt(j)||pattern.charAt(j)=='.'){
                    dp[r][c] = dp[r-1][c-1];
                }else  if (pattern.charAt(j)=='*'){
                    if (words.charAt(i)==pattern.charAt(j-1)){
                        dp[r][c] = dp[r-1][c];
                    }else {
                        dp[r][c] = dp[r][c-2];
                    }
                }else {
                    dp[r][c] = false;
                }
            }
        }
        return dp[wLength-1][pLength-1];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = new WildcardMatching().isMatch(s, p);
        System.out.println(res);
    }
}
