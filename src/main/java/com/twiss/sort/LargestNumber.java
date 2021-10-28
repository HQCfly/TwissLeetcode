package com.twiss.sort;

import java.util.Arrays;

/**
 * @Author: Twiss
 * @Date: 2021/10/28 11:08 下午
 */
public class LargestNumber {

    public String getLargestNumber(int[] numbers){
        int n = numbers.length;
        String[] ss = new String[n];
        for (int i=0;i<n;++i){
            ss[i] =""+numbers[i];
        }
        Arrays.sort(ss,(a,b)->{
            String sa = a+b,sb=b+a;
            return sb.compareTo(sa);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:ss){
            stringBuilder.append(s);
        }
        int len = stringBuilder.length();
        int k = 0;
        while (k<len-1&& stringBuilder.charAt(k)=='0'){
            k++;
        }
        return stringBuilder.substring(k);
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String res = new LargestNumber().getLargestNumber(nums);
        System.out.println(res);
    }
}
