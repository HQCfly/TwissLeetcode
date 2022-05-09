package com.twiss.greed;

/**
 * 分割平衡字符串
 * @Author: Twiss
 * @Date: 2022/5/9 9:37 下午
 */
public class BalancedStringSplit {

    public int getBalance(String words){
        int count = 0, result = 0;
        for (int i=0;i<words.length();i++){
            if (words.charAt(i)=='R'){
                count++;
            }else {
                count--;
            }
            if (count==0){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String words = "RLRRLLRLRL";
        int ans = new BalancedStringSplit().getBalance(words);
        System.out.println(ans);
    }
}
