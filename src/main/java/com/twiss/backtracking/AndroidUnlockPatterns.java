package com.twiss.backtracking;

/**
 * @Author: Twiss
 * @Date: 2021/5/11 7:45 下午
 */
public class AndroidUnlockPatterns {
    // 是否使用过
    private boolean[] used = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int i = m; i <= n; i++) {
            res += calculatePatterns(-1, i);
        }
        return res;
    }

    public int calculatePatterns(int last, int remaining) {
        if (remaining == 0) {
            return 1;
        }
        int resl = 0;
        for (int i = 0; i < 9; i++) {
            if (!used[i] && isValid(last, i)) {
                used[i] = true;
                resl += calculatePatterns(i, remaining - 1);
                used[i] = false;
            }
        }
        return resl;
    }

    private boolean isValid(int last, int pos) {
        // 第一个点
        if (last == -1) {
            return true;
        } else if (Math.abs(pos - last) % 2 == 1) {
            // 水平、垂直邻居和马型
            return true;
        } else if (Math.abs(pos - last) == 6 && used[(pos + last) / 2]) {
            // 垂直两个跳点，可连接。中间跳点已使用。
            return true;
        } else if (Math.abs(pos - last) == 2 && (pos + last) % 6 == 2 && used[(pos + last) / 2]) {
            // 水平最边两个跳点（1，3），并且中间跳点已使用
            return true;
        } else if ((pos + last) == 8 && pos % 2 == 0 && used[4]) {
            // （2，6）跳点并且5点已使用
            return true;
        } else if (Math.abs(pos - last) == 4 && (pos + last) != 8) {
            // （4，8）跳点
            return true;
        } else if (Math.abs(pos - last) == 2 && (pos + last) % 6 != 2) {
            //（4，6）（7，9）跳点
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // m,n代表密码长度范围
        int m = 1, n = 1;
        int result = new AndroidUnlockPatterns().numberOfPatterns(m, n);
        System.out.println(result);
    }
}
