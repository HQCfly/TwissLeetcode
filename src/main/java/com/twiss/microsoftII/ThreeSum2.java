package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;
import com.twiss.microsoft.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 三数之和
 * 时间复杂度
 * 空间复杂度
 *
 * @Author: Twiss
 * @Date: 2022/3/11 2:35 下午
 */
public class ThreeSum2 {

    public List<List<Integer>> getSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; ++i) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                String key = String.format("%d,%d,%d",nums[i],nums[j],nums[k]);
                int sum = nums[i]+nums[j]+nums[k];
                if (sum==0){
                    if (!hashSet.contains(key)){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        hashSet.add(key);
                        res.add(tmp);
                    }
                    k--;
                    j++;
                }else if (sum<0){
                    j++;
                }else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = new ThreeSum2().getSum(nums);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
