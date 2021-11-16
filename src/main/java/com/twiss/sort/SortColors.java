package com.twiss.sort;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2021/11/13 11:13 下午
 */
public class SortColors {

    public void sortedColors(int[] nums){
        int len = nums.length;
        int p1 = 0, p2=len-1;
        for (int i =0;i<p2;++i){
            while (i<=p2&&nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                --p2;
            }
            if (nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = tmp;
                p1++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        new SortColors().sortedColors(nums);
        System.out.println(JSONObject.toJSONString(nums));
    }
}
