package com.twiss.meituan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * 合法元组数
 * @Author: Twiss
 * @Date: 2022/8/15 9:14 下午
 */
public class ValidThreeArrays {

    public int getNumsOfValidArrays(int[] nums){
        int ans = 0;
        if (nums==null||nums.length==0){
            return ans;
        }
        nums = IntStream.of(nums)          // 变为 IntStream
                .boxed()           // 装盒变为 Stream<Integer>
                .sorted(Comparator.reverseOrder()) // 按自然序相反排序
                .mapToInt(Integer::intValue)       // 变为 IntStream
                .toArray();        // 又变回 int[]
        int n = nums.length;
        for (int i=0;i<n-2;i++){
            for (int j=i+1;j<n-1;j++){
                int k = n-1;
                while (j<k){
                    int res1 = nums[i]-nums[j];
                    int res2 = 2*nums[j]-nums[k];
                    if (res1==res2){
                        ans++;
                    }
                    k--;
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,5,6};
        int ans = new ValidThreeArrays().getNumsOfValidArrays(nums);
        System.out.println(ans);
    }
}
