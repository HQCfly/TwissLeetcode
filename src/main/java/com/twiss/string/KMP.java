package com.twiss.string;

/**
 * KMP
 * @Author: Twiss
 * @Date: 2022/6/7 3:46 下午
 */
public class KMP {

    public int strStr(String haystack, String needle){
        if (needle.length()==0){
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(needle,next);
        int j = 0;
        for (int i=0;i<haystack.length();i++){
            while (j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            if (needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            if (j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    private void getNext(String needle, int[] next){
        int j = 0;
        next[0] = 0;
        for (int i = 1;i<needle.length();i++){
            while (j>0&&needle.charAt(i)!=needle.charAt(j)){
                j = next[j-1];
            }
            if (needle.charAt(i)==needle.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }


    public static void main(String[] args) {
        String haystack = "aabaabaafa";
        String needle = "aabaaf";
        int ans = new KMP().strStr(haystack,needle);
        System.out.println(ans);
    }
}
