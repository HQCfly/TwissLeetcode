package com.twiss.string;

/**
 * 翻转字符串II
 * 每隔k个字符进行翻转一次
 * @Author: Twiss
 * @Date: 2022/6/5 8:34 下午
 */
public class ReverseStringII {

    public String getNewString(String s, int k) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int start = 0;
        while (start < len) {
            // 找到k和2k位置
            StringBuilder tmp = new StringBuilder();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstLen = Math.min(start + k, len);
            int secondLen = Math.min(start + 2*k, len);
            tmp.append(s.substring(start,firstLen));
            res.append(tmp.reverse());
            if (firstLen<secondLen){
                res.append(s.substring(firstLen, secondLen));
            }
            start += 2*k;
        }
        return res.toString();
    }

    public String getNewStringBySwap(String s, int k){
        char[] ch = s.toCharArray();
        int n = s.length();
        for (int i=0;i<s.length();i+=2*k){
            int start = i;
            int end = Math.min(n-1,start+k-1);
            while (start<end){
                ch[start]^=ch[end];
                ch[end]^=ch[start];
                ch[start]^=ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String ans = new ReverseStringII().getNewString(s,k);
        System.out.println(ans);

        String s2 = "abcdefg";
        int k2 = 2;
        String ans2 = new ReverseStringII().getNewStringBySwap(s2,k2);
        System.out.println(ans2);
    }
}
