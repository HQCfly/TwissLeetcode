package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

/**
 * TLV解析II
 * @Author: Twiss
 * @Date: 2022/6/23 1:12 下午
 */
public class TLVII {

    public int[][] getTag(String ltv,int[] tags){
        if (ltv==null||ltv.length()==0){
            return null;
        }
        int n = tags.length;
        int[][] ans = new int[n][2];
        int preIndex = 0;
        for (int i=0;i<ltv.length();i+=preIndex){
            int tag = convertHex(ltv.substring(i,i+2));
            int len = Integer.parseInt(ltv.substring(i+2,i+4));
            for (int j=0;j<tags.length;j++){
                if (tag==tags[j]){
                    ans[j][0] = len;
                    ans[j][1] = preIndex/2+2;
                }
            }
            preIndex += 2*len+4;
        }
        return ans;
    }

    private int convertHex(String hex){
       return Integer.parseInt(hex,16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String tlv = sc.nextLine();
            int n = sc.nextInt();
            int[] tags = new int[n];
            for (int i=0;i<n;i++){
                tags[i] = sc.nextInt();
            }
            int[][] ans = new TLVII().getTag(tlv,tags);
            System.out.println(JSONObject.toJSONString(ans));
        }
    }
}
