package com.twiss.greed;

/**
 * 单调递增数字
 * 时间复杂度O(N)
 * 空间复杂度O(1)
 * @Author: Twiss
 * @Date: 2022/5/7 10:11 下午
 */
public class MonotoneIncreasingDigits {

    public int getMaxDigits(int number){
        if (number==0){
            return 0;
        }
        String num = String.valueOf(number);
        char[] chars = num.toCharArray();
        int start = num.length();
        int n = num.length();
        for (int i=n-2;i>=0;i--){
            if (chars[i]>chars[i+1]){
                chars[i]--;
                start = i+1;
            }
        }
        for (int i=start;i<n;i++){
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        int n = 123234;
        int ans = new MonotoneIncreasingDigits().getMaxDigits(n);
        System.out.println(ans);
    }

}
