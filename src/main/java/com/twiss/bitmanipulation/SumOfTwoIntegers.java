package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/18 3:57 下午
 */
public class SumOfTwoIntegers {

    /**
     * 5-101  7-111
     * 异或操作相当于每个位相加，     如：101^111->010 表示2
     * 计算进位值：与运算在左移一位   如：101&111->101 <<1 是1010 表示10
     * 重复以上操作 010^1010->1000 表示8  010&1010->10 <<1 是100 表示4
     * 1000^100->1100 1000&100->0000<<1 无进位值
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a,int b){
        while (b!=0){
            int temp = a^b;
            b = (a&b)<<1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 8, b=10;
        int ans = new SumOfTwoIntegers().getSum(a,b);
        System.out.println(ans);
    }
}
