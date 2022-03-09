package com.twiss.shenxinfu;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Twiss
 * @Date: 2022/3/9 8:19 下午
 */
public class ShuffleArray {
    public int[] shuffle (int[] arr, int i) {
        // write code here
        int n = arr.length;
        int[] tmpA = new int[i];
        int[] tmpB = new int[n-i];
        int[] ans = new int[n];
        int secondLen = n-i;
        boolean aIslongLen = true;
        int longLen = i;
        if(i<=n-i){
            aIslongLen = false;
        }
        if(!aIslongLen){
            longLen = secondLen;
        }

        for(int k =0,m=0;k<n;++k){
            if(k<i){
                tmpA[k] = arr[k];
            }else{
                tmpB[m] = arr[k];
                m++;
            }
        }
        int index=0;
        for(int j=0;j<longLen;++j){
            if(aIslongLen){
                ans[index] = tmpA[j];
                if(j<secondLen){
                    index++;
                    ans[index] = tmpB[j];
                }
            }else{
                if(j<i){
                    ans[index] = tmpA[j];
                }
                index++;
                ans[index] = tmpB[j];
            }
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7};
        int k = 2;
        int[] ans = new ShuffleArray().shuffle(arr,k);
        System.out.println(JSONObject.toJSONString(ans));
    }
}
