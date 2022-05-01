package com.twiss.greed;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * K次取反后最大化的数组和
 * 时间复杂度O()
 * 空间复杂度O()
 *
 * @Author: Twiss
 * @Date: 2022/5/1 11:47 下午
 */
public class LargestSumAfterKNegations {

    public int getMaxSum(int[] arrays,int k){
        if (arrays==null||arrays.length==0){
            return 0;
        }
        arrays = IntStream.of(arrays)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int n = arrays.length-1;
        for (int i=0;i<=n;i++){
            if (arrays[i]<0&&k>0){
                arrays[i] = -arrays[i];
                k--;
            }
        }
        while (k>0){
            arrays[n] = -arrays[n];
            k--;
        }
        return Arrays.stream(arrays).sum();
    }

    public static void main(String[] args) {
        int[] arrays = {2,-3,-1,5,-4};
        int k = 2;
        int ans = new LargestSumAfterKNegations().getMaxSum(arrays,k);
        System.out.println(ans);
    }
}
