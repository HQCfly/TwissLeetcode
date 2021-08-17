package com.twiss.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/8/17 9:27 下午
 */
public class SingleNumberII {

    /**
     * hash表算法
     * @param nums
     * @return
     */
    public int getSingleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();

        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (int key: map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return -1;
    }

    public int getSingleNumberByStatisticBit(int[] nums){

        int[] cnt = new int[32];
        for (int num: nums){
            for (int i=0;i<32;++i){
                if (((num>>i)&1)==1){
                    cnt[i]++;
                }
            }
        }

        int ans = 0;
        for (int i=0;i<32;++i){
            if ((cnt[i]%3&1)==1){
                ans +=(1<<i);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = {2,2,1};
        int ans = new SingleNumberII().getSingleNumber(nums);
        System.out.println(ans);

        int ans2 = new SingleNumberII().getSingleNumberByStatisticBit(nums);
        System.out.println(ans2);
    }
}
