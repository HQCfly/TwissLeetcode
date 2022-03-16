package com.twiss.microsoftII;

import com.alibaba.fastjson.JSONObject;

/**
 * Excel表列名称
 * @Author: Twiss
 * @Date: 2022/3/16 6:51 下午
 */
public class ConvertIntoTitle {

    public String getTitle(int cn){
        StringBuilder stringBuilder = new StringBuilder();
        while (cn>0){
            cn--;
            stringBuilder.append((char)(cn % 26 + 'A'));
            cn/=26;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int cn = 3;
        String res = new ConvertIntoTitle().getTitle(cn);
        System.out.println(JSONObject.toJSONString(res));
    }
}
