package com.twiss.microsoftII;

/**
 * 编码解码
 * 时间复杂度
 * @Author: Twiss
 * @Date: 2022/2/27 1:25 下午
 */
public class TheNumberDecoding {

    public int getNum(String s){
        int n = s.length();
        int[] f = new int[n+10];
        f[0] = 1;
        for (int i=1;i<n;++i){
            if(s.charAt(i-1)!='0'){
                f[i] = f[i-1];
            }
            if (i>=2){
                int t = (s.charAt(i-2)-'0')*10+s.charAt(i-1)-'0';
                if (t>=10&&t<=26){
                    f[i]+=f[i-2];
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        String s = "12";
        int ans = new TheNumberDecoding().getNum(s);
        System.out.println(ans);
    }
}
