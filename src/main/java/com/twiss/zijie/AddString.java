package com.twiss.zijie;

/**
 * 字符串相加
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 *
 * @Author: Twiss
 * @Date: 2022/4/20 8:35 下午
 */
public class AddString {

    public String getSum(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuilder ans = new StringBuilder();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "23";
        String ans = new AddString().getSum(num1, num2);
        System.out.println(ans);
    }
}
