package com.twiss.binarysearch;

/**
 * @Author: Twiss
 * @Date: 2021/7/15 6:13 下午
 */
public class DivideTwoInteger {

    public int getResult(int a, int b){
        int x=a,y=b;
        boolean isNeg = false;
        if ((x>0&&y<0)||(x<0&y>0)){
            isNeg = true;
        }
        if (x<0){
            x = -x;
        }
        if (y<0){
            y = -y;
        }
        long l =0,r = x;
        while (l<r){
            long mid = l+r+1>>1;
            if (mul(mid,y)<=x){
                l = mid;
            }else {
                r = mid-1;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)ans;

    }

    private  long mul(long a, long k){
        int ans = 0;
        while (k>0){
            if ((k&1)==1){
                ans +=a;
            }
            k>>=1;
            a+=a;
        }
        return ans;
    }

    public static void main(String[] args) {
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        int res = divideTwoInteger.getResult(10,3);
        System.out.println(res);
    }
}
