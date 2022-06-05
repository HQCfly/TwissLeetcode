package com.twiss.string;

/**
 * 替换空格字符串
 * 将空格替换成%20
 * @Author: Twiss
 * @Date: 2022/6/5 9:13 下午
 */
public class ReplaceString {

    public String getReplaceString(String s){
        if(s == null || s.length() == 0){
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' '){
                // 添加两个空格
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        int left = s.length()-1;
        s+=str.toString();
        int right = s.length()-1;
        char[] chars = s.toCharArray();
        while (left>=0){
            if (chars[left]==' '){
                chars[right--]='0';
                chars[right--]='2';
                chars[right]='%';
            }else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello world";
        String ans = new ReplaceString().getReplaceString(s);
        System.out.println(ans);
    }
}
