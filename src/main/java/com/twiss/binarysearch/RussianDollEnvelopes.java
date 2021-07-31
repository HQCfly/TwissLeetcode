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
        return envelopes[mid][0] < envelopes[j][0] && envelopes[mid][1] < envelopes[j][1];
    }

    private int getMaxEnvelopesByBinarySearch(int[][] envelopes){
        int n = envelopes.length;
        if (n==0){
            return n;
        }
        // 由于我们使用了 g 记录高度，因此这里只需将 w 从小到达排序即可
        Arrays.sort(envelopes, (a, b)->a[0] - b[0]);
        // f[i] 为考虑第i个物品，并以第i个物品为结尾的的最大值
        int[] f = new int[n];
        // g[i] 记录长度为i的最长上升子序列最小信封高度
        int[] g = new int[n];
        Arrays.fill(g,Integer.MAX_VALUE);
        g[0] = 0;
        int ans = 1;
        for (int i=0,j=0,len=1;i<n;i++){
            // 构建g，对于相同的w数据不更新数组g
            if (envelopes[i][0]!=envelopes[j][0]){
                // 限制j不能超过i，确保g数组中只会出现i个信封前的"历史信封"
                while (j<i){
                    int pre = f[j], cur = envelopes[j][1];
                    if (pre==len){
                        g[len++] = cur;
                    }else {
                        g[len] = Math.min(pre,cur);
                    }
                    j++;
                }
            }
            // 二分过程
            // g[i]上升子序列长度为i的最小信封高度
            int l = 0, r = len;
            while (l<r){
                int mid = l+r>>1;
                if (envelopes[i][1]<=g[mid]){
                    r = mid;
                } else {
                    l = mid+1;
                }
            }
            f[i] = l;
            ans = Math.max(f[i],ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int res = new RussianDollEnvelopes().getMaxEnvelopesByDp(envelopes);
        System.out.println(res);

        int[][] envelopes2 = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int res2 = new RussianDollEnvelopes().getMaxEnvelopesByBinarySearch(envelopes2);
        System.out.println(res2);
    }
}
