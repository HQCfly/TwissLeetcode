package com.twiss.dynamic;

/**
 * @Author: Twiss
 * @Date: 2021/5/29 9:23 下午
 */
public class RegularExpressionMatching {

    private boolean isMatch(String s, String p) {
        // 当p为空，说明模式串为空
        if (p == null) {
            return s == null;
        }
        // 当s为空则表示模式串不可能匹配到任何串
        if (s == null && p.length() == 1) {
            return false;
        }

        int m = s.length() + 1;
        int n = p.length() + 1;
        // m表示字符串的长度，n表示模式串长度
        boolean[][] dp = new boolean[m][n];
        // 定义初始位置为true
        dp[0][0] = true;
        // 从第2下标开始遍历模式串
        for (int j = 2; j < n; j++) {
            // 当j-1下标遇到*，则j的状态由j-2所决定
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        // 从第1下标开始遍历字符串
        for (int r = 1; r < m; r++) {
            // 设置临时变量i，表示r的前一个
            int i = r - 1;
            // 从1下标开始遍历模式串
            for (int c = 1; c < n; c++) {
                // 设置临时变量j，表示c的前一个
                int j = c - 1;
                // 即正好能够匹配或者相对应的是一个 .
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    // 此时的rc状态由r-1和c-1决定
                    dp[r][c] = dp[r - 1][c - 1];
                } else if (p.charAt(j) == '*') {//即匹配到了万能字符 *
                    // 如果*的前一个字符正好对应了状态转移方程是dp[r][c] = dp[r - 1][c]
                    // 如果p的前一个字符正好是.则状态转移方程是dp[r][c] = dp[r][c - 2]
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[r][c] = dp[r - 1][c] || dp[r][c - 2];
                    } else {
                        dp[r][c] = dp[r][c - 2];
                    }
                } else {
                    dp[r][c] = false;
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        boolean res = new RegularExpressionMatching().isMatch(s, p);
        System.out.println(res);
    }
}
