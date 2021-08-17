package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/17 8:17 下午
 */
public class ReverseBits {

    /**
     * 逐步对n检查，如果是1则将ans其左移31-i位即可
     * @param n
     * @return
     */
    public int getReverseBit(int n){
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1) {
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }

    /**
     * 每次都使用 n 的最低一位，使用 n 的最低一位去更新答案的最低一位，
     * 使用完将 n 进行右移一位，将答案左移一位。
     * @param n
     * @return
     */
    public int getReverseBitByLowerBit(int n){
        int ans = 0;
        for (int i=0;i<32;++i){
            ans = (ans<<1)|(n&1);
            n>>=1;
        }
        return ans;
    }

    /**
     *
     * @param n
     * @return
     */
    public int getReverseBitsByDive(int n) {
        n = ((n & 0xAAAAAAAA) >>> 1)  | ((n & 0x55555555) << 1);
        n = ((n & 0xCCCCCCCC) >>> 2)  | ((n & 0x33333333) << 2);
        n = ((n & 0xF0F0F0F0) >>> 4)  | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xFF00FF00) >>> 8)  | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xFFFF0000) >>> 16) | ((n & 0x0000FFFF) << 16);
        return n;
    }

    public static void main(String[] args) {
        int bit = 10111;
        int res = new ReverseBits().getReverseBit(bit);
        System.out.println(res);

        int res2 = new ReverseBits().getReverseBitByLowerBit(bit);
        System.out.println(res2);

        int res3 = new ReverseBits().getReverseBitsByDive(bit);
        System.out.println(res3);
    }
}
