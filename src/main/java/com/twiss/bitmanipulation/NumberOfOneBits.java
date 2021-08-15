package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/15 5:43 下午
 */
public class NumberOfOneBits {

    /**
     * 循环检查二进制
     * 当n的第i位与2^i进行与运算为1时，运算结果不为0
     * @param bits
     * @return
     */
    public int hammingWeight(int bits){
        int ret = 0;
        for (int i=0;i<32;i++){
            if ((bits&(1<<i))!=0){
                ret++;
            }
        }
        return ret;
    }

    /**
     * 位运算优化
     * n&(n-1)把n的二进制位中最低位1变0之后的结果
     * @param bits
     * @return
     */
    public int hammingWeightByBrianKernighan(int bits){
        int ret = 0;
        while (bits>0){
            bits &= (bits-1);
            ret++;
        }
        return ret;

    }

    public static void main(String[] args) {
        int bits = 0000011;
        int res = new NumberOfOneBits().hammingWeight(bits);
        System.out.println(res);
        int res2 = new NumberOfOneBits().hammingWeightByBrianKernighan(bits);
        System.out.println(res2);
    }
}
