package com.twiss.bitmanipulation;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/8/14 11:01 上午
 */
public class CountBit {

    /**
     * BrianKernighan算法
     * 利用 Brian Kernighan 算法，可以在一定程度上进一步提升计算速度。
     * 算法的原理是：对于任意整数 x，令 x=x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，
     * 对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     *
     * @param n
     * @return
     */
    public int[] getCountByBrianKernighan(int n){
        int[] res = new int[n];
        for (int i=0;i<n;i++){
            res[i] = countOnes(i);
        }
        return res;
    }

    public int countOnes(int x){
        int ones = 0;
        while (x>0){
            x&=(x-1);
            ones++;
        }
        return ones;
    }

    /**
     * 动态规划——最高有效位
     * 如果 i&(i-1)=0，则令 highBit=i，更新当前的最高有效位。
     * i 比 i−highBit 的「一比特数」多 1，由于是从小到大遍历每个整数，因此遍历到 i 时，i−highBit 的「一比特数」已知，
     * 令 bits[i]=bits[i−highBit]+1。
     *
     * @param n
     * @return
     */
    public int[] getCountByDpHighBit(int n){
        int[] res = new int[n];
        int highBit = 0;
        for (int i=1;i<n;i++){
            if ((i&(i-1))==0){
                highBit = i;
            }
            res[i] = res[i-highBit]+1;
        }
        return res;
    }
    /**
     * 动态规划：低有效位
     * bits[x]=bits[x>>1]+(x & 1)。
     * @param n
     * @return
     */
    public int[] getCountByDpLowBit(int n){
        int[] res = new int[n];
        for (int i=1;i<n;i++){
            res[i] = res[i>>1]+(i&1);
        }
        return res;
    }
    /**
     * 动态规划——最低设置位
     * bits[x]=bits[x & (x−1)]+1。
     * @param n
     * @return
     */
    public int[] getCountByDpLowSetBit(int n){
        int[] res = new int[n];
        for (int i=1;i<n;i++){
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n =5;
        int[] res = new CountBit().getCountByBrianKernighan(n);
        System.out.println(JSONObject.toJSONString(res));

        int[] res2 = new CountBit().getCountByDpHighBit(n);
        System.out.println(JSONObject.toJSONString(res2));

        int[] res3 = new CountBit().getCountByDpLowBit(n);
        System.out.println(JSONObject.toJSONString(res3));

        int[] res4 = new CountBit().getCountByDpLowSetBit(n);
        System.out.println(JSONObject.toJSONString(res4));
    }
}
