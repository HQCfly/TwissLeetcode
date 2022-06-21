package com.twiss.huawei;

import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

/**
 * 找到比自己强的人
 * @Author: Twiss
 * @Date: 2022/6/21 10:34 下午
 */
public class FindStrongPeople {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int numLen = sc.nextInt();
            int[][] arr = new int[numLen][];
            int i = 0;
            // 放到此处
            sc.nextLine();
            while(i < numLen){
                String[] str = sc.nextLine().split(",");
                arr[i] = new int[]{Integer.parseInt(str[0]),Integer.parseInt(str[1])};
                i++;
            }
            System.out.println(JSONObject.toJSONString(arr));
        }

    }
}
