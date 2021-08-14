package com.twiss.bitmanipulation;

/**
 * @Author: Twiss
 * @Date: 2021/8/14 6:59 下午
 */
public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] len = new int[n];

        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                bitmask |= 1 << bitNumber(ch);
            }
            masks[i] = bitmask;
            len[i] = words[i].length();
        }

        int maxVal = 0;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if ((masks[i]&masks[j])==0){
                    maxVal = Math.max(maxVal,len[i]*len[j]);
                }
            }
        }
        return maxVal;
    }

    private int bitNumber(char ch) {
        return (int) ch - (int) 'a';
    }

    public static void main(String[] args) {
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        int res= new MaximumProductOfWordLengths().maxProduct(words);
        System.out.println(res);
    }
}
