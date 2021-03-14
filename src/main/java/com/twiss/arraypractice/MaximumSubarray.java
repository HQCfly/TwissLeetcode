package com.twiss.arraypractice;

/**
 * @Author: Twiss
 * @Date: 2021/3/14 7:22 下午
 */
public class MaximumSubarray {

    public static class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public static Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public static Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
    public static int maxSubarrayByDivideAndConquer(int[] numbers){
        return getInfo(numbers,0,numbers.length-1).mSum;
    }

    public static int maxSubarray(int[] numbers){
        int pre = numbers[0], maxAns = numbers[0];
        for(int i: numbers){
            pre = Math.max(pre+i,i);
            maxAns = Math.max(pre,maxAns);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int[] numbers = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubarray(numbers);
        System.out.println(res);
        int res2 = maxSubarrayByDivideAndConquer(numbers);
        System.out.println(res2);
    }
}
