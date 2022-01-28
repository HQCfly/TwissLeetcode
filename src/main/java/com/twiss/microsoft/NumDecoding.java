package com.twiss.microsoft;

/**
 * @Author: Twiss
 * @Date: 2022/1/28 2:40 下午
 */
public class NumDecoding {

    public int decoding(String s){
        int n = s.length();
        s = " "+s;
        char[] cs = s.toCharArray();
        int[] f = new int[n+1];
        f[0] = 1;
        for (int i=1;i<=n;++i){
            // a: 代表当前位置能够独立形成item
            // b: 代表当前位置与前一个位置能够形成item
            int a = cs[i]-'0';
            int b = (cs[i-1]-'0')*10+a;
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (0<=a&&a<=9){
                f[i] = f[i-1];
            }
            if (10<=b&&b<=26){
                // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
                f[i] += f[i-2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        String s = "12";
        int res = new NumDecoding().decoding(s);
        System.out.println(res);
    }
}
