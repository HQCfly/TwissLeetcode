package com.twiss;

/**
 * 翻转字符串
 * @Author: Twiss
 * @Date: 2022/6/8 8:33 下午
 */
public class ReverseString {

    public String getNewString(String s){
        if (s==null||s.length()==0){
            return null;
        }
        // 去除头尾空格
        StringBuilder sb = trim(s);
        // 翻转字符串
        reverse(sb,0,s.length()-1);
        // 可以搞个for循环处理

        // 翻转每个单词
        reverseWord(sb);
        return new String(sb);
    }

    public StringBuilder trim(String s){
        int left = 0, right = s.length()-1;
        while (left<=right&&s.charAt(left)==' '){
            left++;
        }
        while (left<=right&&s.charAt(right)==' '){
            right--;
        }

        StringBuilder sb = new StringBuilder();
        while (left<=right){
            char c = s.charAt(left);
            if (c!=' '){
                sb.append(c);
            }else if (sb.charAt(sb.length()-1)!=' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right){
        while (left<=right){
            char tmp = sb.charAt(left);
            // 交换
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--,tmp);
        }
    }

    public void reverseWord(StringBuilder sb){
        int n = sb.length();
        int left = 0,right = 0;
        while (left<n){
            // 遍历单词到末尾
            while (right<n&&sb.charAt(right)!=' '){
                right++;
            }
            // 开始翻转
            reverse(sb,left,right-1);
            left = right+1;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "I am student";
        String ans = new ReverseString().getNewString(s);
        System.out.println(ans);
    }
}
