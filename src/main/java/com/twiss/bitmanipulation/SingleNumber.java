package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/17 9:27 下午
 */
public class SingleNumber {

    /**
     * 异或算法
     * @param nums
     * @return
     */
    public int getSingleNumber(int[] nums){
        int ans = 0;
        for (int num:nums){
            ans ^=num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int ans = new SingleNumber().getSingleNumber(nums);
        System.out.println(ans);
    }
}
