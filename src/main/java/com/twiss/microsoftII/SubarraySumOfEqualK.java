package com.twiss.microsoftII;

import java.util.HashMap;

/**
 * 和为k的子数组
 * 前缀和
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 * @Author: Twiss
 * @Date: 2022/3/21 7:36 下午
 */
public class SubarraySumOfEqualK {

    public int getNumberOfSubarray(int[] nums,int target){
        int count = 0,pre = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<nums.length;++i){
            pre+=nums[i];
            if (map.containsKey(pre-target)){
                count++;
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int target = 2;
        int ans = new SubarraySumOfEqualK().getNumberOfSubarray(nums,target);
        System.out.println(ans);
    }
}
