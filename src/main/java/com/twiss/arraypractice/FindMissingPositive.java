package com.twiss.arraypractice;

public class FindMissingPositive {

    public static int solve(int[] array){
        int n = array.length;
        for (int i = 0; i < n; ++i){
            if (array[i]<=0){
                array[i] = n + 1;
            }
        }

        for (int i = 0; i < n; ++i){
            int a = Math.abs(array[i]);
            if (a < n){
                array[a-1] = -Math.abs(array[a-1]);
            }
        }

        for (int i = 0; i < n; ++i){
            if (array[i] > 0){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,0};
        int res = solve(array);
        System.out.println(res);
    }
}
