package com.twiss.wangyi;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 三元数组
 * @Author: Twiss
 * @Date: 2022/8/20 3:24 下午
 */
public class ThreeArrays {

    public int getNums(int[] arrays){
        int ans = 0;
        if (arrays==null||arrays.length==0){
            return ans;
        }
        int n = arrays.length;
        Set<String> tmpSet = new HashSet<>();
        for (int start = 0;start<n-2;start++){
            int i = start+1;
            int j = n-1;
            while (i<j){
                if (isValid(arrays,start,i,j)){
                    String ft = String.format("%s-%s-%s",start,i,j);
                    tmpSet.add(ft);
                }
                i++;
            }
            int tmpI = start+1;
            while (tmpI<j){
                if (isValid(arrays,start,tmpI,j)){
                    String ft = String.format("%s-%s-%s",start,tmpI,j);
                    tmpSet.add(ft);
                }
                j--;
            }

        }
        System.out.println(JSONObject.toJSONString(tmpSet));
        return tmpSet.size();
    }

    private boolean isValid(int[] arrays, int start, int i,int j){
        if (arrays[start]==arrays[j]&&arrays[start]>arrays[i]&&arrays[j]>arrays[i]){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2};
        int ans = new ThreeArrays().getNums(nums);
        System.out.println(ans);
    }
}
