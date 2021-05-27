package com.twiss.backtracking;

/**
 * @Author: Twiss
 * @Date: 2021/5/27 7:58 下午
 */
public class PermutationSequence {
    private String getSequence(int n, int k) {
        int[] factorial = getFactorial(n);
        StringBuilder target = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        backtrace(n, 0, k, used, factorial, target);
        return target.toString();
    }

    private void backtrace(int n, int index, int k, boolean[] used, int[] factorial, StringBuilder target) {
        if (index == n) {
            return;
        }
        // 所求的全排列一定在叶子节点得到，
        // 进入每个分支，根据已经选择的的数的个数index，进而计算还未选定的个数n-index-1，然后计算阶乘。就知道这一个分支的也自己点的个数
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            // 如果k大于cnt表示 该节点分支所有的叶子节点都不是第k个排列
            // 如果k小于等于cnt表示 所求的全排列一定在这个分支中
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            target.append(i);
            used[i] = true;
            backtrace(n, index + 1, k, used, factorial, target);
            return;
        }
    }

    private int[] getFactorial(int n) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        return factorial;
    }

    public static void main(String[] args) {
        int n = 3, k = 3;
        String res = new PermutationSequence().getSequence(n, k);
        System.out.println(res);
    }
}
