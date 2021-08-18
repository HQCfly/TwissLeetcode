package com.twiss.bitmanipulation;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Twiss
 * @Date: 2021/8/17 9:27 下午
 */
public class SingleNumberIII {

    /**
     * hash表算法
     * @param nums
     * @return
     */
    public int[] getSingleNumber(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int i = 0;
        for (int key: map.keySet()){
            if (map.get(key)==1){
                res[i] = key;
                i++;
            }
        }
        return res;
    }

    /**
     * 异或^：0^0=0 0^1=1 1^0=1 1^1=0
     * @param nums
     * @return
     */
    public int[] getSingleNumberByExclusiveOr(int[] nums){
        int res = 0;
        // 最终的res是两个不相同的数异或结果
        for (int num:nums){
            res^=num;
        }
        // 逐位寻找1的位置
        int div =1;
        while ((div&res)==0){
            div<<=1;
        }
        int a=0,b=0;
        for (int num:nums){
            if ((num&div)!=0){
                // 对于同一个元素，异或结果是0，因此能够存储只出现一次的元素
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int ans[] = new SingleNumberIII().getSingleNumber(nums);
        System.out.println(JSONObject.toJSONString(ans));

        int[] ans2 = new SingleNumberIII().getSingleNumberByExclusiveOr(nums);
        System.out.println(JSONObject.toJSONString(ans2));
    }
}
