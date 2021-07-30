package com.twiss.binarysearch;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/7/27 9:16 下午
 */
public class RussianDollEnvelopes {

    private int getMaxEnvelopesByDp(int[][] envelopes) {
        int len = envelopes.length;
        if (len == 0) {
            return len;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
        // f(i) 为考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int[] f = new int[len];
        int ans = 1;
        for (int i = 0; i < len; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (check(envelopes, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    private boolean check(int[][] envelopes, int mid, int j) {
        return envelopes[mid][0]<envelopes[j][0]&&envelopes[mid][1]<envelopes[j][1];
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int res = new RussianDollEnvelopes().getMaxEnvelopesByDp(envelopes);
        System.out.println(res);
    }
}
