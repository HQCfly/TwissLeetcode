package com.twiss.shopee;

/**
 * 建房子
 * @Author: Twiss
 * @Date: 2022/4/6 7:29 下午
 */
public class BuildHouse {

    public int count = 0;

    private int buildHouses(int n) {
        int[] cr = new int[n];
        backtrace(n, 0, cr);
        return count;
    }

    private void backtrace(int n, int row, int[] cr) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 第row行第i列
            cr[row] = i;
            if (!isValidHouse(i, row, cr)) {
                continue;
            }
            backtrace(n, row + 1, cr);
        }
    }

    private boolean isValidHouse(int col, int row, int[] cr) {
        for (int r = 0; r < row; r++) {
            // |行标-列标| == |边界行-边界列|
            if (cr[r] == col || row - r == Math.abs(cr[r] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 1;
        int ans = new BuildHouse().buildHouses(n);
        System.out.println(ans);
    }
}
