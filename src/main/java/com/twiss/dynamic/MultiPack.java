package com.twiss.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多重背包
 * @Author: Twiss
 * @Date: 2022/5/17 1:02 下午
 */
public class MultiPack {

    public int getPack(List<Integer> weight, List<Integer> value, List<Integer> nums, int bagWeight){
        // 重新构建多重背包权重
        for (int i=0;i<nums.size();i++){
            while (nums.get(i)>1){
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums.set(i,nums.get(i)-1);
            }
        }
        int[] dp = new int[bagWeight+1];
        // 先遍历物品，在遍历背包
        for (int i=0;i<weight.size();i++){
            for (int j=bagWeight;j>=weight.get(i);j--){
                dp[j] = Math.max(dp[j],dp[j-weight.get(i)]+value.get(i));
            }
        }
        return dp[bagWeight];
    }

    public static void main(String[] args) {
        List<Integer> weight = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> value = new ArrayList<>(Arrays.asList(15, 20, 30));
        List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 2));
        int bagWeight = 10;
        int ans = new MultiPack().getPack(weight,value,nums,bagWeight);
        System.out.println(ans);
    }
}
