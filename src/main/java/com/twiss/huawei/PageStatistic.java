package com.twiss.huawei;

/**
 * 题目描述：
 * 页码显示，对于总页码N<7，则显示所有页码，反之则最多只显示7个页码（首页页码、尾页页码、当前页K以及当前页前后两页的页码）；未显示的连续页码用省略号“…”代替。
 * 如：N=94，K=5，则显示页码1 … 3 4 5 6 7 … 94；N=94，K=93，则显示页码1 … 91 92 93 94。
 * <p>
 * 输入：两个空格分开的整数N ,K (1≤ K ≤ N ≤ 100)，分别表示总页数和当前页。
 * 输出：所显示的页码，用空格分开，未显示的连续页码用省略号”…”统一代替。
 *
 * @Author: Twiss
 * @Date: 2022/8/2 3:14 下午
 */
public class PageStatistic {

    public String getPage(int n, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isDot = true;
        boolean isTailDot = true;
        if (n > 100 | n < 1 || k > n) {
            return null;
        }
        if (n < 7) {
            for (int i = 1; i <= n; i++) {
                stringBuilder.append(String.valueOf(i)).append(" ");
            }
            return new String(stringBuilder);
        } else {
            for (int i = 1; i <= n; i++) {
                if (i == 1 && (i != k - 1)) {
                    stringBuilder.append(String.valueOf(i)).append(" ");
                }
                if ((i != k - 2) && (i != k - 1) && (i < k - 2) || (i < k - 1)) {
                    if (isDot) {
                        stringBuilder.append("...").append(" ");
                        isDot = false;
                    }
                }
                if ((i != 1) && i == k - 2 || i == k - 1 || i == k || i == k + 1 || i == k + 2) {
                    stringBuilder.append(String.valueOf(i)).append(" ");
                }
                if ((i > k + 1 || i > k + 2) && (k - 2 < n && k - 1 < n && k < n && k + 1 < n && k + 2 < n)) {
                    if (isTailDot) {
                        stringBuilder.append("...").append(" ");
                        isTailDot = false;
                    }
                }
                if ((i != k - 2) || (i != k - 1) || (i != k) || (i != k + 1) || (i != k + 2)) {
                    if (n == i) {
                        stringBuilder.append(String.valueOf(i));
                    }
                }
            }
            return new String(stringBuilder);
        }
    }

    public static void main(String[] args) {

        int n = 7;
        int k = 3;
        String ans = new PageStatistic().getPage(n, k);
        System.out.println(ans);

        int n2 = 7;
        int k2 = 2;
        String ans2 = new PageStatistic().getPage(n2, k2);
        System.out.println(ans2);

        int n3 = 7;
        int k3 = 4;
        String ans3 = new PageStatistic().getPage(n3, k3);
        System.out.println(ans3);

        int n4 = 7;
        int k4 = 6;
        String ans4 = new PageStatistic().getPage(n4, k4);
        System.out.println(ans4);
    }

}
