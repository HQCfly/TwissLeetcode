package com.twiss.xiaohuang.assignment1;

/**
 * @Author: Twiss
 * @Date: 2021/9/4 7:46 下午
 */
public class Test {

    private int count = 0;

    public int function(int n){
        count++;
//        System.out.println("count: "+count);
        int sumCount = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sumCount++;
            sum += 1;
        }
        if (n > 0) {
            int res = sum + function(n - 1);
//            System.out.println("n: "+n+", sum: "+sum+" res: "+res+" sumCount: "+sumCount);
            return res;
        }
        else{
            return 0;
        }
    }

    public int function2(int n){

        if (n == 1) {
            return 1;
        }
        return n + function2(n-1);
    }

    public int function3(int n){

        if (n==0){
            return 1;
        }else {
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += function3(i);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int ans = new Test().function(n);
        System.out.println("ans:"+ans);

        int ans2=  new Test().function2(n);
        System.out.println("ans2:"+ans2);

        int ans3=  new Test().function3(n);
        System.out.println("ans3:"+ans3);
    }
}
