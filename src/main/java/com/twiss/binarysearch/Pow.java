package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/26 8:22 下午
 */
public class Pow {

    private double getPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    private double getPow2(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul2(x, N) : 1.0 / quickMul2(x, -N);
    }

    private double quickMul2(double x, long N) {
        double ans = 1.0;
        double xContribute = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= xContribute;
            }
            xContribute *= xContribute;
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        double res = new Pow().getPow(x,n);
        System.out.println(res);

        double res2 = new Pow().getPow2(x,n);
        System.out.println(res2);
    }
}
